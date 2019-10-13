package org.jaun.idontbyte.beanvalidationexample.domain.model;

import java.util.Objects;
import java.util.UUID;

public class RegistrationId {
    private final UUID value;

    public RegistrationId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public String asString() {
        return value.toString();
    }
}
