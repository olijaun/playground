package org.jaun.idontbyte.beanvalidationexample.domain.model;

import java.util.UUID;

public class RegistrationService {

    public RegistrationId register(RegistrationCommand registrationCommand) {

        RegistrationId registrationId = new RegistrationId(UUID.randomUUID());

        // perform registration

        return registrationId;
    }
}
