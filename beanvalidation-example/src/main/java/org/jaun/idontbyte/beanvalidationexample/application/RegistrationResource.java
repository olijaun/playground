package org.jaun.idontbyte.beanvalidationexample.application;

import org.jaun.idontbyte.beanvalidationexample.domain.model.EmailAddress;
import org.jaun.idontbyte.beanvalidationexample.domain.model.RegistrationCommand;
import org.jaun.idontbyte.beanvalidationexample.domain.model.RegistrationId;
import org.jaun.idontbyte.beanvalidationexample.domain.model.RegistrationService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/registrations")
public class RegistrationResource {

    @Inject
    private RegistrationService registrationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Path("")
    public Response register(@Valid RegistrationDto registrationDto) {

        EmailAddress emailAddress = new EmailAddress(registrationDto.getEmailAddress());

        RegistrationCommand registrationCommand
                = new RegistrationCommand(registrationDto.getName(), emailAddress, registrationDto.getPassword());

        RegistrationId registrationId = registrationService.register(registrationCommand);

        return Response.ok(registrationId.asString()).build();
    }
}
