package com.depromeet.schedule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.member.entity.Member;
import com.depromeet.schedule.dto.AttendanceId;

@Entity
@IdClass(AttendanceId.class)
public class Attendance {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;
	
	@Column(name = "attendance_code", nullable = false)
	private Long attendanceCode;
	
	public Attendance() {
	}
	
	public Attendance(Member member, Schedule schedule, Long attendanceCode) {
		setMember(member);
		setSchedule(schedule);
		setAttendanceCode(attendanceCode);
	}

	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Long getAttendanceCode() {
		return attendanceCode;
	}

	public void setAttendanceCode(Long attendanceCode) {
		this.attendanceCode = attendanceCode;
	}
}
