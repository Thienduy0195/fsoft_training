package com.java.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDTO implements Validator {

  final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

  @NotBlank(message = "Required!")
  String username;

  @NotBlank(message = "Required!")
  String email;

  @NotBlank(message = "Required!")
  String password;

  @NotBlank(message = "Required!")
  String repassword;

  public UserDTO() {
  }

  public UserDTO(String username, String email, String password,
      String repassword) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.repassword = repassword;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public String getRepassword() {
    return repassword;
  }

  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }

  @Override
  public String toString() {
    return "UserDTO [username=" + username + ", email=" + email + ", password="
        + password + ", repassword=" + repassword + "]";
  }

  @Override
  public boolean supports(Class<?> clazz) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void validate(Object target, Errors errors) {

    UserDTO userDTO = (UserDTO) target;

    if (!userDTO.getEmail().matches(REGEX_EMAIL)) {
      errors.rejectValue("email", "email", "Email is in wrong format!");
    }

  }
}
