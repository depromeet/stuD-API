package com.depromeet.schedule.dto;

import java.io.Serializable;

public class AttendanceId implements Serializable {
	
	private static final long serialVersionUID = -8718642965191809132L;
	
	private Long member;
	private Long schedule;
	
	public AttendanceId() {
	}
	
	public AttendanceId(Long member, Long schedule) {
		this.member = member;
		this.schedule = schedule;
	}
	
	public Long getMember() {
		return member;
	}
	
	public void setMember(Long member) {
		this.member = member;
	}
	
	public Long getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Long schedule) {
		this.schedule = schedule;
	}
}
