package com.depromeet.schedule.dto;

import java.util.Date;

import com.depromeet.schedule.entity.Schedule;
import com.depromeet.schedule.entity.Subject;

public class ScheduleDto {
	
	private Long scheduleId;
	private String title;
	private String description;
	private String category;
	private String content;
	private Date startAt;
	private Date endAt;
	private Long createdBy;
	private Date createdAt;
	
	public Long getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getStartAt() {
		return startAt;
	}
	
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	
	public Date getEndAt() {
		return endAt;
	}
	
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
	
	public Long getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public static ScheduleDto fromSchedule(Schedule schedule) {
		ScheduleDto scheduleDto = new ScheduleDto();
		Subject subject = schedule.getSubject();
		
		scheduleDto.setScheduleId(schedule.getScheduleId());
		scheduleDto.setTitle(subject.getTitle());
		scheduleDto.setDescription(subject.getDescription());
		scheduleDto.setCategory(subject.getSubjectCategory().getValue());
		scheduleDto.setContent(schedule.getContent());
		scheduleDto.setStartAt(schedule.getStartAt());
		scheduleDto.setEndAt(schedule.getEndAt());
		scheduleDto.setCreatedBy(schedule.getCreatedBy().getMemberId());
		scheduleDto.setCreatedAt(schedule.getCreatedAt());
		
		return scheduleDto;
	}
}
