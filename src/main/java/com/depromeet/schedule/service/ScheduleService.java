package com.depromeet.schedule.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depromeet.common.utils.CalendarUtils;
import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<Schedule> getScheduleByDate(int year, int month, int week) {
		Date startDate = CalendarUtils.getFirstDayOfWeek(year, month, week);
		Date endDate = CalendarUtils.getFirstDayOfWeek(year, month, week + 1);
		
		return scheduleRepository.findByStartAtBetweenOrEndAtBetween(
				startDate, endDate, startDate, endDate);
	}
}
