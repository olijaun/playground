package org.jaun.idontbyte.beanvalidationexample.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JerseyObjectMapperProvider.class);
        register(ConstraintViolationExceptionMapper.class);
        register(RegistrationResource.class);
    }
}
