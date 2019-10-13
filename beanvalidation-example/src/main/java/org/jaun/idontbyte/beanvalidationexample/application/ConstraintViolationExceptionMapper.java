package org.jaun.idontbyte.beanvalidationexample.application;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    public Response toResponse(ConstraintViolationException e) {

        List<ValidationErrorDto> collect = e.getConstraintViolations().stream()
                .map(v -> new ValidationErrorDto(toLocation(v), v.getMessage())).collect(Collectors.toList());
        ErrorDto errorDto = new ErrorDto();
        errorDto.getErrors().addAll(collect);


        return Response.status(Response.Status.BAD_REQUEST).entity(errorDto).build();
    }

    private String toLocation(ConstraintViolation v) {
        String[] pathElements = v.getPropertyPath().toString().split("\\.");
        return Stream.of(pathElements).skip(2).collect(Collectors.joining("."));
    }
}
