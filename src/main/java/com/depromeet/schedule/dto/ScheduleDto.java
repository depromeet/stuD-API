package com.depromeet.schedule.dto;

import java.util.Set;

public class ScheduleDto {
	
	public static final int ATTEND = 1;
	public static final int LATE = 2;
	public static final int NOT_ATTEND = 3;
	
	private Long scheduleId;
	private String name;
	private String description;
	private String leader;
	private String content;
	private Set<String> attendMembers;
	private Set<String> lateMembers;
	private Set<String> notAttendMembers;
	
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
	
	public Set<String> getAttendMembers() {
		return attendMembers;
	}
	
	public void setAttendMembers(Set<String> attendMembers) {
		this.attendMembers = attendMembers;
	}
	
	public Set<String> getLateMembers() {
		return lateMembers;
	}
	
	public void setLateMembers(Set<String> lateMembers) {
		this.lateMembers = lateMembers;
	}
	
	public Set<String> getNotAttendMembers() {
		return notAttendMembers;
	}
	
	public void setNotAttendMembers(Set<String> notAttendMembers) {
		this.notAttendMembers = notAttendMembers;
	}
}
