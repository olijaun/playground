package org.jaun.idontbyte.beanvalidationexample.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorDto implements Serializable {

    private List<ValidationErrorDto> errors = new ArrayList<>();

    public List<ValidationErrorDto> getErrors() {
        return errors;
    }
}
