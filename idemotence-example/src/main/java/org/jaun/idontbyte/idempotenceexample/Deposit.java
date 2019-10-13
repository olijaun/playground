package org.jaun.idontbyte.idempotenceexample;

import java.io.Serializable;

public class Deposit implements Serializable {

    private int amount;
    private String currency;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
