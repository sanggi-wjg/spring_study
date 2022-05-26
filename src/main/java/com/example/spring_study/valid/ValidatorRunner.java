package com.example.spring_study.valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ValidatorRunner implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("[Validator]");
        System.out.println(validator.getClass());

        Something something = new Something();
        something.setEmail("2");
        something.setLimit(-2);

        Errors errors = new BeanPropertyBindingResult(something, "myValue");
        validator.validate(something, errors);
        System.out.println("HasError: " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println(e.getObjectName() + "\t" + e.getCode() + "\t" + e.getDefaultMessage());
        });
        System.out.println("=================================================================");
    }
}

