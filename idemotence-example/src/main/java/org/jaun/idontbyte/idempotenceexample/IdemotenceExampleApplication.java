package org.jaun.idontbyte.idempotenceexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class IdemotenceExampleApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(IdemotenceExampleApplication.class, args);
    }

    @PostConstruct
    private void initDb() {

        String sqlStatements[] = {
                "drop table request if exists",
                "drop table deposit if exists",
                "create table request(request_id varchar(255))",
                "alter table request ADD CONSTRAINT C1 UNIQUE ( request_id )",
                "create table deposit(deposit_id varchar(255), amount int, currency varchar(255))",
                "alter table deposit ADD CONSTRAINT C2 UNIQUE ( deposit_id )",
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });
    }
}
