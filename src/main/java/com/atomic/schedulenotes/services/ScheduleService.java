package com.atomic.schedulenotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomic.schedulenotes.dto.NoteDTO;
import com.atomic.schedulenotes.dto.ScheduleDTO;
import com.atomic.schedulenotes.model.Note;
import com.atomic.schedulenotes.model.Schedule;
import com.atomic.schedulenotes.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository repo;

	public List<Schedule> findAll() {
		return repo.findAll();
	}

	public Schedule findById(String uuid) {
		return repo.findById(uuid).get();
	}

	public Schedule saveSchedule(ScheduleDTO objDto) {
		Schedule obj = Schedule.parseFromDTO(objDto);
		return repo.saveAndFlush(obj);
	}



}
