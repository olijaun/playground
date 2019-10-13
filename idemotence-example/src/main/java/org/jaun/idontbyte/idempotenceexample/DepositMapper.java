package org.jaun.idontbyte.idempotenceexample;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class DepositMapper implements RowMapper<Deposit> {

    @Override
    public Deposit mapRow(ResultSet rs, int i) throws SQLException {
        Deposit deposit = new Deposit();
        deposit.setAmount(rs.getInt("amount"));
        deposit.setCurrency(rs.getString("currency"));
        return deposit;
    }
}
