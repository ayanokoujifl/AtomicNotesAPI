package com.atomic.schedulenotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atomic.schedulenotes.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, String>{

}
