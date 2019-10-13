package org.jaun.idontbyte.beanvalidationexample.application;

import java.io.Serializable;

public class ValidationErrorDto implements Serializable {

    private String location;
    private String message;

    public ValidationErrorDto(String location, String message) {
        this.location = location;
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
