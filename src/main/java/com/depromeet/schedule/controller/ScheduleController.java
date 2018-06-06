package com.depromeet.schedule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.member.entity.Member;
import com.depromeet.member.service.MemberService;
import com.depromeet.schedule.dto.AttendanceDto;
import com.depromeet.schedule.dto.ScheduleDto;
import com.depromeet.schedule.entity.Attendance;
import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.entity.Study;
import com.depromeet.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<List<ScheduleDto>> loadSchedules(
			@RequestParam int year, @RequestParam int month, @RequestParam int week) {
		
		List<Schedule> scheduleList = 
				scheduleService.loadSchedulesByDate(year, month, week);
		
		Member member = memberService.loadMemberByToken()
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		List<ScheduleDto> scheduleDtoList = scheduleList.stream()
				.map(schedule -> scheduleDtoFromEntity(schedule, member))
				.collect(Collectors.toList());
		
		return new ApiResponse<>(scheduleDtoList);
	}
	
	@GetMapping("/{scheduleId}/attendance")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<List<AttendanceDto>> loadAttendance(@PathVariable Long scheduleId,
			@RequestParam int year, @RequestParam int month, @RequestParam int week) {
		
		List<AttendanceDto> attendances =
				scheduleService.loadAttendanceByScheduleId(scheduleId).stream()
				.map(attendance -> attendanceDtoFromEntity(attendance))
				.collect(Collectors.toList());
		
		return new ApiResponse<>(attendances);
	}
	
	@PostMapping("/{scheduleId}/attendance")
	@ResponseStatus(HttpStatus.OK)
	public void setAttendance(@PathVariable Long scheduleId,
			@RequestBody AttendanceDto attendanceDto) {
		
		Member member = memberService.loadMemberByToken()
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		scheduleService.setAttendance(member.getMemberId(), scheduleId,
				attendanceDto.getAttendanceCode());
	}
	
	private ScheduleDto scheduleDtoFromEntity(Schedule schedule, Member member) {
		ScheduleDto scheduleDto = new ScheduleDto();
		Study study = schedule.getStudy();
		
		scheduleDto.setScheduleId(schedule.getScheduleId());
		scheduleDto.setName(study.getName());
		scheduleDto.setDescription(study.getDescription());
		scheduleDto.setLeader(study.getLeader().getName());
		scheduleDto.setContent(schedule.getContent());
		
		List<String> attendMembers = new ArrayList<>();
		List<String> lateMembers = new ArrayList<>();
		List<String> notAttendMembers = new ArrayList<>();
		List<String> guestMembers = new ArrayList<>();
		
		schedule.getAttendance().stream()
				.forEach(a -> {
					String memberName = a.getMember().getName();
					
					switch (a.getAttendanceCode().intValue()) {
					case ScheduleDto.ATTEND:
						if (a.getMember().getJoinedStudy().getStudyId() ==
								study.getStudyId()) {
							attendMembers.add(memberName);
						} else {
							guestMembers.add(memberName);
						}
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
				});
		
		scheduleDto.setAttendMembers(attendMembers);
		scheduleDto.setLateMembers(lateMembers);
		scheduleDto.setNotAttendMembers(notAttendMembers);
		scheduleDto.setGuestMembers(guestMembers);
		scheduleDto.setIsLeader(member.getMemberId() == study.getLeader().getMemberId());
		
		return scheduleDto;
	}
	
	private AttendanceDto attendanceDtoFromEntity(Attendance attendance) {
		AttendanceDto attendanceDto = new AttendanceDto();
		Member member = attendance.getMember();
		
		attendanceDto.setMemberId(member.getMemberId());
		attendanceDto.setMemberName(member.getName());
		attendanceDto.setAttendanceCode(attendance.getAttendanceCode());
		attendanceDto.setIsGuest(member.getJoinedStudy().getStudyId() !=
				attendance.getSchedule().getStudy().getStudyId());
		
		return attendanceDto;
	}
}
