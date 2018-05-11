package com.depromeet.schedule.dto;

public class AttendanceDto {
	
	private Long memberId;
	private String memberName;
	private Long attendanceCode;
	private Boolean isGuest;
	
	public Long getAttendanceCode() {
		return attendanceCode;
	}
	
	public void setAttendanceCode(Long attendanceCode) {
		this.attendanceCode = attendanceCode;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Boolean getIsGuest() {
		return isGuest;
	}

	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}
}
