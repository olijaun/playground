package org.jaun.idontbyte.idempotence.idemotenceexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/accounts/{id}")
public class AccountResource {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/deposits")
    public Response getDeposits() {
        List<Deposit> deposits = jdbcTemplate.query( //
                "select deposit_id,amount,currency from deposit",
                new DepositMapper());

        return Response.ok(deposits).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/deposits/{deposit-id}")
    public Response getDepositById(@PathParam("deposit-id") String depositId) {
        Deposit deposit = getDeposit(depositId);
        if (deposit == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(deposit).build();
    }

    private Deposit getDeposit(String depositId) {

        return DataAccessUtils.singleResult(jdbcTemplate.query( //
                "select deposit_id,amount,currency from deposit where deposit_id = ?",
                new DepositMapper(), depositId));
    }

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/deposits")
    @Transactional
    public Response addDeposit(Deposit deposit, @HeaderParam("x-request-id") String requestId) {

        try {
            String newDepositId = UUID.randomUUID().toString();
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    saveRequestId(requestId);
                    saveNewDeposit(newDepositId, deposit);
                }
            });
            return Response.ok(newDepositId).build();
        } catch (Exception e) {
            if (requestIdExists(requestId)) {
                return Response.status(Response.Status.CONFLICT).build();
            }
            throw e;
        }
    }

    @PUT
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/deposits/{deposit-id}")
    @Transactional
    public Response updateDeposit(@PathParam("deposit-id")String depositId, Deposit deposit) {

        Deposit existingDeposit = getDeposit(depositId);
        if(existingDeposit == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        update(depositId, deposit);
        return Response.noContent().build();
    }

    private void saveRequestId(String requestId) {
        if (requestId != null) {
            jdbcTemplate.update("insert into request(request_id) values(?)", requestId);
        }
    }

    private void saveNewDeposit(String newDepositId, Deposit deposit) {
        jdbcTemplate.update(//
                "insert into deposit(deposit_id, amount, currency) values(?, ?, ?);", //
                newDepositId, deposit.getAmount(), deposit.getCurrency());
    }

    private void update(String depositId, Deposit deposit) {
        jdbcTemplate.update(//
                "update deposit set amount=?, currency=? where deposit_id=?;", //
                deposit.getAmount(), deposit.getCurrency(), depositId);
    }

    private boolean requestIdExists(String requestId) {

        return jdbcTemplate.query("select request_id from request where request_id = ?",
                (rs, i) -> rs.getString("request_id"), requestId).size() > 0;
    }
}