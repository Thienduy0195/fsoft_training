package com.java.repos;

import java.util.List;
import java.util.Optional;

import com.java.dto.UserDTO;
import com.java.model.Member;

public interface IMemberRepos {
	List<Member> findAll();

	Optional<Member> findByEmailAndPassword(String email, String password);

    void editMember(Member member);

    Optional<Member> findByEmail(String email);

    void saveMember(UserDTO registerDTO);
}
