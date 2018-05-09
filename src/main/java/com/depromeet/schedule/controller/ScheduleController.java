package com.depromeet.schedule.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.schedule.dto.ScheduleDto;
import com.depromeet.schedule.entity.Attendance;
import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.entity.Study;
import com.depromeet.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping
	public ApiResponse<List<ScheduleDto>> getSchedule(
			@RequestParam int year, @RequestParam int month, @RequestParam int week) {
		List<Schedule> scheduleList = scheduleService.getScheduleByDate(year, month, week);
		
		List<ScheduleDto> scheduleDtoList = new ArrayList<>();
		scheduleList.stream()
				.map(schedule -> scheduleDtoList.add(scheduleDtoFromEntity(schedule)))
				.collect(Collectors.toList());
		
		return new ApiResponse<>(scheduleDtoList);
	}
	
	private ScheduleDto scheduleDtoFromEntity(Schedule schedule) {
		ScheduleDto scheduleDto = new ScheduleDto();
		Study study = schedule.getStudy();
		
		scheduleDto.setScheduleId(schedule.getScheduleId());
		scheduleDto.setName(study.getName());
		scheduleDto.setDescription(study.getDescription());
		scheduleDto.setLeader(study.getLeader().getName());
		scheduleDto.setContent(schedule.getContent());
		
		Set<String> attendMembers = new HashSet<>();
		Set<String> lateMembers = new HashSet<>();
		Set<String> notAttendMembers = new HashSet<>();
		
		for (Attendance attendance : schedule.getAttendance()) {
			String memberName = attendance.getMember().getName();
			
			switch (attendance.getAttendanceCode().getCodeId().intValue()) {
			case ScheduleDto.ATTEND:
				attendMembers.add(memberName);
				break;
			case ScheduleDto.LATE:
				lateMembers.add(memberName);
				break;
			case ScheduleDto.NOT_ATTEND:
				notAttendMembers.add(memberName);
				break;
			default:
				break;
			}
		}
		
		scheduleDto.setAttendMembers(attendMembers);
		scheduleDto.setLateMembers(lateMembers);
		scheduleDto.setNotAttendMembers(notAttendMembers);
		
		return scheduleDto;
	}
}
