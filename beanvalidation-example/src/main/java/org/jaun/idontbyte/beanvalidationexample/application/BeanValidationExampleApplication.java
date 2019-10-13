package org.jaun.idontbyte.beanvalidationexample.application;

import org.jaun.idontbyte.beanvalidationexample.domain.model.RegistrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanValidationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanValidationExampleApplication.class, args);
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationService();
    }
}
