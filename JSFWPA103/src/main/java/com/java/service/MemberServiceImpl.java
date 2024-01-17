package com.java.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.java.dto.AccountDTO;
import com.java.dto.UserDTO;
import org.springframework.stereotype.Service;
import com.java.model.Member;
import com.java.repos.IMemberRepos;
import com.java.repos.MemberReposImpl;

@Service

public class MemberServiceImpl implements IMemberService {

    IMemberRepos repos;

    public MemberServiceImpl(MemberReposImpl memberReposImpl) {
        this.repos = memberReposImpl;
    }

    @Override
    public List<Member> findAll() {
        return repos.findAll();
    }

    @Override
    public Member editMember(Member member, HttpSession session) {
        repos.editMember(member);
        return addSession(session, member.getEmail(), member.getPassword());
    }

    @Override
    public Member findByEmailAndPassword(AccountDTO accountDTO, HttpSession session) {
        Optional<Member> member = repos.findByEmailAndPassword(accountDTO.getEmail(), accountDTO.getPassword());
        if (member.isPresent()) {
            session.setAttribute("user", member.get());
            return member.get();
        }
        return null;
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return repos.findByEmail(email);
    }

    @Override
    public void save(UserDTO registerDTO, HttpSession session) {
        repos.saveMember(registerDTO);
        addSession(session, registerDTO.getEmail(), registerDTO.getPassword());
    }

    private Member addSession(HttpSession session, String email, String password) {
        Optional<Member> optionalMember = repos.findByEmailAndPassword(email, password);
        if (optionalMember.isPresent()) {
            session.setAttribute("user", optionalMember.get());
            return optionalMember.get();
        }
        return null;
    }
}
