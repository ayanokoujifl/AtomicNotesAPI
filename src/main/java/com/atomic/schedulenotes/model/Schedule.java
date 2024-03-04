package com.atomic.schedulenotes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.atomic.schedulenotes.dto.ScheduleDTO;
import com.atomic.schedulenotes.model.enums.Rate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	private String title;
	private LocalDateTime schedule;
	private LocalDate createdAt;
	private Rate urgencia;

	public Schedule() {
	}

	public Schedule(String title, LocalDateTime schedule, Integer urgencia) {
		super();
		this.title = title;
		this.schedule = schedule;
		this.createdAt = LocalDate.now();
		this.urgencia = Rate.parse(urgencia);
	}

	public static Schedule parseFromDTO(ScheduleDTO objDto) {
		Schedule obj = new Schedule(objDto.getTitle(), objDto.getSchedule(), objDto.getRate().getId());
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

	public LocalDateTime getSchedule() {
		return schedule;
	}

	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Rate getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(Rate urgencia) {
		this.urgencia = urgencia;
	}
}
