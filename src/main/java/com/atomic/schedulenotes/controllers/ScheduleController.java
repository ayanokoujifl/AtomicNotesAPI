package com.atomic.schedulenotes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.atomic.schedulenotes.dto.ScheduleDTO;
import com.atomic.schedulenotes.model.Schedule;
import com.atomic.schedulenotes.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

	@Autowired
	ScheduleService service;

	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@PostMapping
	public ResponseEntity<Schedule> saveSchedule(@RequestBody ScheduleDTO objDto) {
		Schedule obj = service.saveSchedule(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(obj.getUuid())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
