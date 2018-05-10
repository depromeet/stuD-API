package com.depromeet.schedule.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depromeet.schedule.entity.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	
	List<Schedule> findByStartAtBetweenOrEndAtBetween(
			Date startAtStartDate, Date startAtEndDate,
			Date endAtStartDate, Date endAtEndDate);
}
