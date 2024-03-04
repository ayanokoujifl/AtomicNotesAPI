package com.atomic.schedulenotes.model;

import java.time.LocalDateTime;

import com.atomic.schedulenotes.dto.NoteDTO;
import com.atomic.schedulenotes.model.enums.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;	
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	private String title;
	private String content;
	private Category category;
	private LocalDateTime createdAt;
	private boolean isRead;

	public Note() {
		this.createdAt = LocalDateTime.now();
	}

	public Note(String title, String content, Integer category, boolean isRead) {
		super();
		this.title = title;
		this.content = content;
		this.category = Category.parse(category);
		this.createdAt = LocalDateTime.now();
		this.isRead = isRead;
	}

	public static Note parseFromDTO(NoteDTO objDto) {
		Note obj = new Note(objDto.getTitle(), objDto.getContent(), objDto.getCategory().getId(), objDto.isRead());
		obj.setUuid(objDto.getUuid());
		return obj;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}
