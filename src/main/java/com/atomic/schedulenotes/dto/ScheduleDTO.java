package com.atomic.schedulenotes.dto;

import java.time.LocalDateTime;

import com.atomic.schedulenotes.model.enums.Rate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDTO {
	private String title;
	private Rate rate;
	@JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm")
	private LocalDateTime schedule;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public LocalDateTime getSchedule() {
		return schedule;
	}

	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}
}
