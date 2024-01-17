package com.java.utils;

import com.java.dto.UserDTO;
import org.springframework.validation.Errors;
 import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO registerDTO = (UserDTO) target;
        if(!registerDTO.getPassword().equals(registerDTO.getRepassword())){
            errors.rejectValue("repassword"," not match with password");
        }
    }
}
