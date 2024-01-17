package com.java.dto;

import com.java.model.Content;
 import org.hibernate.validator.constraints.NotBlank;

public class ContentDTO {
    Long id;
    @NotBlank
    String title;
    @NotBlank
    String brief;
    @NotBlank
    String description;

    public ContentDTO(Content content) {
        this.id = content.getId();
        this.title = content.getTitle();
        this.brief = content.getBrief();
        this.description = content.getContent();
    }

    public ContentDTO() {
 	}

	public ContentDTO(Long id, String title, String brief, String description) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
