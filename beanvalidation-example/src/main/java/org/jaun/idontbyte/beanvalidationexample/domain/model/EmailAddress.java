package org.jaun.idontbyte.beanvalidationexample.domain.model;

import java.util.Objects;

public class EmailAddress {
    private String emailAddress;

    public EmailAddress(String emailAddress) {
        this.emailAddress = Objects.requireNonNull(emailAddress);
        // more validations
    }

    public String asString() {
        return emailAddress;
    }
}
