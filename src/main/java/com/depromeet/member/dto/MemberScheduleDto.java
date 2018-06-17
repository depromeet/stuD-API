package com.depromeet.member.dto;

import java.util.Date;

public class MemberScheduleDto {
	
	private String name;
	private Date startAt;
	private Long attendanceCode;
	private Boolean isGuest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	
	public Long getAttendanceCode() {
		return attendanceCode;
	}
	
	public void setAttendanceCode(Long attendanceCode) {
		this.attendanceCode = attendanceCode;
	}
	
	public Boolean getIsGuest() {
		return isGuest;
	}
	
	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}
}
