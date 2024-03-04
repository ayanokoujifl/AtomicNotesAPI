package com.atomic.schedulenotes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atomic.schedulenotes.model.Note;
import com.atomic.schedulenotes.model.Schedule;
import com.atomic.schedulenotes.repositories.NoteRepository;
import com.atomic.schedulenotes.repositories.ScheduleRepository;

@SpringBootApplication
public class ScheduleNotesApplication implements CommandLineRunner {

	@Autowired
	NoteRepository repoNote;

	@Autowired
	ScheduleRepository repoSchedule;

	public static void main(String[] args) {
		SpringApplication.run(ScheduleNotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Note obj1 = new Note("Dever de casa", "Página 20 a 35", 5, false);
		Schedule obj2 = new Schedule("Introduzir web site HK",
				LocalDateTime.of(LocalDate.parse("2024-02-26"), LocalTime.parse("15:30:00")), 4);
		repoNote.saveAndFlush(obj1);
		repoSchedule.saveAndFlush(obj2);
	}

}
