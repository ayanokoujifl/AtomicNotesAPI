package com.atomic.schedulenotes.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atomic.schedulenotes.dto.NoteDTO;
import com.atomic.schedulenotes.model.Note;
import com.atomic.schedulenotes.services.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	NoteService service;

	@GetMapping
	public ResponseEntity<List<NoteDTO>> findAll() {
		List<Note> list = service.findAll();
		List<NoteDTO> listDto = list.stream().map(obj -> new NoteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<NoteDTO> findByUUID(@PathVariable("id") String uuid) {
		NoteDTO objDto = new NoteDTO(service.findById(uuid));
		return ResponseEntity.ok().body(objDto);
	}

	@PostMapping(headers = "Content-Type")
	public ResponseEntity<Note> save(@RequestBody NoteDTO objDto) {
		Note obj = service.saveNote(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(obj.getUuid())
				.toUri();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		return ResponseEntity.created(uri).headers(httpHeaders).body(obj);
	}

	@PutMapping(value = "/{uuid}")
	public ResponseEntity<Void> update(@RequestBody NoteDTO objDto, @PathVariable String uuid) {
		service.updateNote(objDto, uuid);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> delete(@PathVariable String uuid) {
		service.deleteNote(uuid);
		return ResponseEntity.accepted().build();
	}
}
