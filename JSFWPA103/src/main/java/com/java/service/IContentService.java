package com.java.service;

import com.java.dto.ContentDTO;
import com.java.model.Content;
import com.java.model.Member;

import java.util.List;


public interface IContentService {
    void saveContent(ContentDTO dto, Member member);

    List<Content> findAllByTitle(String title, Member member);


    Content findById(Long id);

    void deleteById(Long id);
}
