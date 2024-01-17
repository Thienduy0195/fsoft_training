package com.java.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.java.dto.AccountDTO;
import com.java.dto.UserDTO;
import com.java.model.Member;

public interface IMemberService {
	List<Member> findAll();

	Member editMember(Member member, HttpSession session);

	Member findByEmailAndPassword(AccountDTO accountDTO, HttpSession session);

	Optional<Member> findByEmail(String email);

    void save(UserDTO registerDTO, HttpSession session);
}
