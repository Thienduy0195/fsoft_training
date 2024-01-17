package com.java.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AccountDTO implements Validator {

  final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

  @NotEmpty(message = "Required!")
  String email;

  @NotEmpty(message = "Required!")
  String password;

  public AccountDTO() {
  }

  public AccountDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "AccountDTO{" + "email='" + email + '\'' + ", password='" + password
        + '\'' + '}';
  }

  @Override
  public boolean supports(Class<?> clazz) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void validate(Object target, Errors errors) {
    AccountDTO accountDTO = (AccountDTO) target;
    if (!accountDTO.getEmail().matches(email)) {
      errors.rejectValue("email", "email", "Email is in wrong format!");
    }

  }
}
