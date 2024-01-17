package com.java.repos;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.java.dto.ContentDTO;
import com.java.model.Content;

@Repository
@Transactional
public class ContentReposImpl implements IContentRepository {

  private SessionFactory sessionFactory;

  public ContentReposImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Content> findAllByTitle(String title, Long id) {
    return sessionFactory.getCurrentSession()
        .createQuery("select c from Content c where c.title like '%" + title
            + "%' and c.member.id = :id", Content.class)
        .setParameter("id", id).getResultList();
  }

  @Override
  public void saveContent(ContentDTO contentDTO, Long id) {
    Content content = new Content(contentDTO, id);
    content.setCreateDate(Date.valueOf(LocalDate.now()));
    sessionFactory.getCurrentSession().persist(content);
  }

  @Override
  public void editContent(ContentDTO contentDTO, Long id) {
    Content content = new Content(contentDTO, id);
    content.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
    content.setId(contentDTO.getId());
    sessionFactory.getCurrentSession().merge(content);
  }

  @Override
  public void deleteById(Long id) {
    sessionFactory.getCurrentSession()
        .createQuery("delete from Content  c where  c.id = :id")
        .setParameter("id", id).executeUpdate();
  }

  @Override
  public Content findById(Long id) {
    return sessionFactory.getCurrentSession()
        .createQuery("select c from Content c where c.id = :id", Content.class)
        .setParameter("id", id).uniqueResultOptional().orElse(null);
  }
}
