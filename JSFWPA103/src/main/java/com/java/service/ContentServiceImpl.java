package com.java.service;

import com.java.dto.ContentDTO;
import com.java.model.Content;
import com.java.model.Member;
import com.java.repos.ContentReposImpl;
import com.java.repos.IContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements IContentService {
    IContentRepository repos;

    public ContentServiceImpl(ContentReposImpl contentRepos) {
        this.repos = contentRepos;
    }


    @Override
    public void saveContent(ContentDTO dto, Member member) {
        if (dto.getId() != null){
            repos.editContent(dto,member.getId());
            return;
        }
        repos.saveContent(dto, member.getId());
    }

    @Override
    public List<Content> findAllByTitle(String title, Member member) {
        return repos.findAllByTitle(title, member.getId());
    }

    @Override
    public Content findById(Long id) {
        return repos.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repos.deleteById(id);
    }

}
