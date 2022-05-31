package com.example.spring_study.example.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class MyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Something.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "title is empty");
    }

}
