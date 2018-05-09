package com.depromeet.schedule.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.common.entity.Code;
import com.depromeet.member.entity.Member;
import com.depromeet.schedule.dto.AttendanceId;

@Entity
@IdClass(AttendanceId.class)
public class Attendance {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attendance_code", nullable = false)
	private Code attendanceCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attendance_category", nullable = false)
	private Code attendanceCategory;

	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	public Code getAttendanceCode() {
		return attendanceCode;
	}

	public void setAttendanceCode(Code attendanceCode) {
		this.attendanceCode = attendanceCode;
	}

	public Code getAttendanceCategory() {
		return attendanceCategory;
	}

	public void setAttendanceCategory(Code attendanceCategory) {
		this.attendanceCategory = attendanceCategory;
	}
}
