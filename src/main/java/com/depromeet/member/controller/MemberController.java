package com.depromeet.member.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.common.exception.UnauthorizedException;
import com.depromeet.member.dto.MemberDto;
import com.depromeet.member.dto.MemberScheduleDto;
import com.depromeet.member.entity.Member;
import com.depromeet.member.service.MemberService;
import com.depromeet.schedule.entity.Attendance;
import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.service.ScheduleService;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<MemberDto> loadMemberInfo(@PathVariable Long memberId) {
		Member member = memberService.loadMemberByToken()
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		if (member.getMemberId() != memberId) {
			throw new UnauthorizedException("권한이 없습니다.");
		}
		
		List<Attendance> attendanceList =
				scheduleService.loadSchedulesByMemberId(memberId);
		
		MemberDto memberDto = entityToMemberDto(member);
		
		List<MemberScheduleDto> memberSchedules = new ArrayList<>();
		for (Attendance attendance : attendanceList) {
			MemberScheduleDto memberScheduleDto = new MemberScheduleDto();
			
			Schedule schedule = attendance.getSchedule();
			memberScheduleDto.setName(schedule.getStudy().getName());
			memberScheduleDto.setStartAt(schedule.getStartAt());
			memberScheduleDto.setAttendanceCode(attendance.getAttendanceCode());
			memberScheduleDto.setIsGuest(member.isGuest(schedule.getStudy()));
			
			memberSchedules.add(memberScheduleDto);
		}
		
		memberDto.setSchedules(memberSchedules);
		memberDto.setAttendedCount(memberService.loadAttendedCount(memberId));
		memberDto.setLateCount(memberService.loadLateCount(memberId));
		memberDto.setNotAttendedCount(memberService.loadNotAttendedCount(memberId));
		
		return new ApiResponse<>(memberDto);
	}
	
	private MemberDto entityToMemberDto(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(member.getMemberId());
		Optional.ofNullable(member.getJoinedStudy())
				.ifPresent(study -> memberDto.setJoinedStudy(study.getName()));
		
		return memberDto;
	}
}
