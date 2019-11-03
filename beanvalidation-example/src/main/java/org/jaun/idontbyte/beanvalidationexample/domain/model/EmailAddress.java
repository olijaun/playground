package org.jaun.idontbyte.beanvalidationexample.domain.model;

import java.util.Objects;

public class EmailAddress {

    public static final String EMAIL_ADDRESS_PATTERN = "[^@]+@[^@]+";
    private String emailAddress;

    public EmailAddress(String emailAddress) {
        this.emailAddress = Objects.requireNonNull(emailAddress);

        if(!emailAddress.matches(EMAIL_ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("invalid email address: " + emailAddress);
        }
    }

    public String asString() {
        return emailAddress;
    }
}
