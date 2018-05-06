package com.depromeet.schedule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.schedule.dto.ScheduleDto;
import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("")
	public ApiResponse<List<ScheduleDto>> getSchedule(
			@RequestParam int year, @RequestParam int month, @RequestParam int week) {
		List<Schedule> scheduleList = scheduleService.getScheduleByDate(year, month, week);
		
		List<ScheduleDto> scheduleDtoList = new ArrayList<>();
		scheduleList.stream()
				.map(schedule -> scheduleDtoList.add(ScheduleDto.fromSchedule(schedule)))
				.collect(Collectors.toList());
		
		return new ApiResponse<>(scheduleDtoList);
	}
}
