package com.atomic.schedulenotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atomic.schedulenotes.model.Note;

public interface NoteRepository extends JpaRepository<Note, String> {

}
