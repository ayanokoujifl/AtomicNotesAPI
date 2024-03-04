package com.atomic.schedulenotes.dto;

import java.time.LocalDateTime;

import com.atomic.schedulenotes.model.Note;
import com.atomic.schedulenotes.model.enums.Category;

public class NoteDTO {

	private String uuid;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Category category;
	private boolean isRead;

	public NoteDTO() {
	}

	public NoteDTO(Note obj) {
		this.uuid = obj.getUuid();
		this.title = obj.getTitle();
		this.createdAt = obj.getCreatedAt();
		this.category = obj.getCategory();
		this.content = obj.getContent();
		this.isRead = obj.isRead();
	}

	public NoteDTO(String uuid, String title, String content, LocalDateTime createdAt, Integer category,
			boolean isRead) {
		super();
		this.uuid = uuid;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.category = Category.parse(category);
		this.isRead = isRead;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}
