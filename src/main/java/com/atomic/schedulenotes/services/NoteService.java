package com.atomic.schedulenotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomic.schedulenotes.dto.NoteDTO;
import com.atomic.schedulenotes.model.Note;
import com.atomic.schedulenotes.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository repo;

	public List<Note> findAll() {
		return repo.findAll();
	}

	public Note findById(String uuid) {
		return repo.findById(uuid).get();
	}

	public Note saveNote(NoteDTO objDto) {
		Note obj = Note.parseFromDTO(objDto);
		return repo.saveAndFlush(obj);
	}

	public void updateNote(NoteDTO objDto, String uuid) {
		objDto.setUuid(uuid);
		Note oldObj = findById(uuid);
		objDto.setCreatedAt(oldObj.getCreatedAt());
		Note obj = Note.parseFromDTO(objDto);
		repo.saveAndFlush(obj);
	}

	public void deleteNote(String uuid) {
		Note obj = findById(uuid);
		repo.delete(obj);
	}

}
