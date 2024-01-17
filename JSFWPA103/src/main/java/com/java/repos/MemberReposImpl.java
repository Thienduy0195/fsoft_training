package com.java.repos;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.java.dto.UserDTO;
import com.java.model.Member;

@Repository
@Transactional
public class MemberReposImpl implements IMemberRepos {

  private SessionFactory sessionFactory;

  public MemberReposImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Member> findAll() {
    return sessionFactory.openSession()
        .createQuery("select m from Member m", Member.class).getResultList();
  }

  @Transactional
  @Override
  public Optional<Member> findByEmailAndPassword(String email,
      String password) {
    String sql = "select m from Member m where m.email = :email and m.password = :password";
    return sessionFactory.getCurrentSession().createQuery(sql, Member.class)
        .setParameter("email", email).setParameter("password", password)
        .uniqueResultOptional();
  }

  @Override
  public void editMember(Member member) {
    member.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
    sessionFactory.getCurrentSession().merge(member);
  }

  @Override
  public Optional<Member> findByEmail(String email) {
    return sessionFactory.getCurrentSession()
        .createQuery("select m from Member m where m.email = :email",
            Member.class)
        .setParameter("email", email).uniqueResultOptional();
  }

  @Override
  public void saveMember(UserDTO registerDTO) {
    Member member = new Member(registerDTO);
    System.out.println("registerDTO" + member.toString());
    sessionFactory.getCurrentSession().persist(member);
  }

}
