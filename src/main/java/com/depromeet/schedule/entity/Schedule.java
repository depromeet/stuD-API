package com.depromeet.schedule.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id", nullable = false)
	private Long scheduleId;

	@ManyToOne
	@JoinColumn(name = "study_id", nullable = false)
	private Study study;
	
	@Column(name = "content", length = 200)
	private String content;
	
	@Column(name = "start_at", nullable = false)
	private Date startAt;
	
	@Column(name = "end_at", nullable = false)
	private Date endAt;
	
	@OneToMany(mappedBy = "schedule")
	private List<Attendance> attendance;
	
	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public Study getStudy() {
		return study;
	}
	
	public void setStudy(Study study) {
		this.study = study;
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
	
	public List<Attendance> getAttendance() {
		return attendance;
	}
	
	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
}
