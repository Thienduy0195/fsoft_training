package com.java.utils;

import com.java.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsEmail implements ConstraintValidator <ValidEmail,String>{
    @Autowired
    IMemberService service;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.findByEmail(value).isPresent();
    }
}
