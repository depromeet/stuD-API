package com.depromeet.schedule.dto;

import java.util.List;

public class ScheduleDto {
	
	public static final int ATTEND = 1;
	public static final int LATE = 2;
	public static final int NOT_ATTEND = 3;
	
	private Long scheduleId;
	private String name;
	private String description;
	private String leader;
	private String content;
	private Boolean decidedAttendance;
	private List<String> attendMembers;
	private List<String> lateMembers;
	private List<String> notAttendMembers;
	private List<String> guestMembers;
	
	public Long getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLeader() {
		return leader;
	}
	
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Boolean getDecidedAttendance() {
		return decidedAttendance;
	}
	
	public void setDecidedAttendance(Boolean decidedAttendance) {
		this.decidedAttendance = decidedAttendance;
	}
	
	public List<String> getAttendMembers() {
		return attendMembers;
	}
	
	public void setAttendMembers(List<String> attendMembers) {
		this.attendMembers = attendMembers;
	}
	
	public List<String> getLateMembers() {
		return lateMembers;
	}
	
	public void setLateMembers(List<String> lateMembers) {
		this.lateMembers = lateMembers;
	}
	
	public List<String> getNotAttendMembers() {
		return notAttendMembers;
	}
	
	public void setNotAttendMembers(List<String> notAttendMembers) {
		this.notAttendMembers = notAttendMembers;
	}
	
	public List<String> getGuestMembers() {
		return guestMembers;
	}
	
	public void setGuestMembers(List<String> guestMembers) {
		this.guestMembers = guestMembers;
	}
}
