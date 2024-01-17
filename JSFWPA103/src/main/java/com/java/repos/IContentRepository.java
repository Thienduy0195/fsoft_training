package com.java.repos;

import com.java.dto.ContentDTO;
import com.java.model.Content;

import java.util.List;

public interface IContentRepository {
    List<Content> findAllByTitle(String title, Long id);

    void saveContent(ContentDTO contentDTO, Long id);

    Content findById(Long id);

    void editContent(ContentDTO contentDTO, Long id);

    void deleteById(Long id);
}
