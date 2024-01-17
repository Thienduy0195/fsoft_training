package com.java.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.dto.UserDTO;

@Entity
@Table(name = "member")
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "firstName")
  String firstname;

  @Column(name = "lastName")
  String lastname;

  @Column(name = "userName")
  String username;

  String password;
  String email;
  String description;

  Date createDate;

  Timestamp updateTime;

  public Member() {
    super();
  }

  public Member(Long id) {
    this.id = id;
  }

  public Member(Long id, String firstname, String lastname, String username,
      String password, String email, String description, Date createDate,
      Timestamp updateTime) {
    super();
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
    this.email = email;
    this.description = description;
    this.createDate = createDate;
    this.updateTime = updateTime;
  }

  public Member(UserDTO registerDTO) {
    this.email = registerDTO.getEmail();
    this.username = registerDTO.getUsername();
    this.password = registerDTO.getPassword();

    this.createDate = Date.valueOf(LocalDate.now());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", firstname=" + firstname + ", lastname="
        + lastname + ", username=" + username + ", password=" + password
        + ", email=" + email + ", description=" + description + ", createDate="
        + createDate + ", updateTime=" + updateTime + "]";
  }
}
