package com.depromeet.schedule.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depromeet.schedule.entity.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
	
	public List<Attendance> findByScheduleScheduleIdIn(Iterable<Long> scheduleIds);
	
	public List<Attendance> findByScheduleScheduleId(Long scheduleId);
}
