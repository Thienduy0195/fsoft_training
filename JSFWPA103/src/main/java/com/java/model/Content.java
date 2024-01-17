package com.java.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.java.dto.ContentDTO;

@Entity
@Table(name = "content")
public class Content {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String title;
  String brief;
  String content;
  Date createDate;
  Timestamp updateTime;
  Integer sort;
  @ManyToOne
  @JoinColumn(name = "authorId", nullable = false, referencedColumnName = "id")
  Member member;

  public Content() {
    super();
  }

  public Content(Long id, String title, String brief, String content,
      Date createDate, Timestamp updateTime, Integer sort, Member member) {
    super();
    this.id = id;
    this.title = title;
    this.brief = brief;
    this.content = content;
    this.createDate = createDate;
    this.updateTime = updateTime;
    this.sort = sort;
    this.member = member;
  }

  public Content(ContentDTO contentDTO, Long id) {
    this.title = contentDTO.getTitle();
    this.brief = contentDTO.getBrief();
    this.content = contentDTO.getDescription();
    this.sort = 1;
    this.member = new Member(id);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "Content{" + "id=" + id + ", title='" + title + '\'' + ", brief='"
        + brief + '\'' + ", content='" + content + '\'' + ", createDate="
        + createDate + ", updateTime=" + updateTime + ", sort=" + sort
        + ", member=" + member + '}';
  }
}
