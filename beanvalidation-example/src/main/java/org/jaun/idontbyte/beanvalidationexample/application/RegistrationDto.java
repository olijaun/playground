package org.jaun.idontbyte.beanvalidationexample.application;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RegistrationDto implements Serializable {

    @NotNull @Email
    private String emailAddress;
    @NotNull @NotBlank
    private String name;
    @NotNull @NotBlank
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void getEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
