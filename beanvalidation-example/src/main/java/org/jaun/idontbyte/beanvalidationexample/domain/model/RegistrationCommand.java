package org.jaun.idontbyte.beanvalidationexample.domain.model;

import java.util.Objects;

public class RegistrationCommand {

    private final String name;
    private final EmailAddress emailAddress;
    private final String password;

    public RegistrationCommand(String name, EmailAddress emailAddress, String password) {
        this.emailAddress = Objects.requireNonNull(emailAddress);
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
    }

    public String getName() {
        return name;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
