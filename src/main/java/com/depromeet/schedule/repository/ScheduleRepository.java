package com.depromeet.schedule.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.depromeet.schedule.entity.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	
	List<Schedule> findByStartAtBetween(Date startDate, Date endDate);
	
	Optional<Schedule> findByScheduleIdAndStartAtBetween(
			Long scheduleId, Date startDate, Date endDate);
}
