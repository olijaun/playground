package org.jaun.idontbyte.idempotence.idemotenceexample;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JerseyObjectMapperProvider.class);
        register(AccountResource.class);
    }
}
