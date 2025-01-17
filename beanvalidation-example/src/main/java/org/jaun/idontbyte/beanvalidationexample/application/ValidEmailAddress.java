package org.jaun.idontbyte.beanvalidationexample.application;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { EmailAddressValidator.class })
public @interface ValidEmailAddress {
    String message() default "invalid email address {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
