package org.jaun.idontbyte.idempotence.idemotenceexample;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JerseyObjectMapperProvider implements ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> type) {

        ObjectMapper result = new ObjectMapper();
        result.configure(SerializationFeature.INDENT_OUTPUT, true);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        result.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        result.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        return result;
    }
}
