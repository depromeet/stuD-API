package com.depromeet.member.dto;

import java.util.List;

public class MemberDto {
	
	private Long memberId;
	private String joinedStudy;
	private Integer attendedCount;
	private Integer lateCount;
	private Integer notAttendedCount;
	private List<MemberScheduleDto> schedules;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	public String getJoinedStudy() {
		return joinedStudy;
	}
	
	public void setJoinedStudy(String joinedStudy) {
		this.joinedStudy = joinedStudy;
	}

	public Integer getAttendedCount() {
		return attendedCount;
	}

	public void setAttendedCount(Integer attendedCount) {
		this.attendedCount = attendedCount;
	}

	public Integer getLateCount() {
		return lateCount;
	}

	public void setLateCount(Integer lateCount) {
		this.lateCount = lateCount;
	}

	public Integer getNotAttendedCount() {
		return notAttendedCount;
	}

	public void setNotAttendedCount(Integer notAttendedCount) {
		this.notAttendedCount = notAttendedCount;
	}

	public List<MemberScheduleDto> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<MemberScheduleDto> schedules) {
		this.schedules = schedules;
	}
}
