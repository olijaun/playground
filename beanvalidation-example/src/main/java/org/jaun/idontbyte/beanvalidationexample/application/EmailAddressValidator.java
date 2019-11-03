package org.jaun.idontbyte.beanvalidationexample.application;

import org.jaun.idontbyte.beanvalidationexample.domain.model.EmailAddress;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailAddressValidator implements ConstraintValidator<ValidEmailAddress, String> {

    @Override
    public void initialize(ValidEmailAddress ageValue) {
    }

    @Override
    public boolean isValid(String emailAddressAsString, ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if (emailAddressAsString == null) {
            return true;
        }

        try {
            new EmailAddress(emailAddressAsString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
