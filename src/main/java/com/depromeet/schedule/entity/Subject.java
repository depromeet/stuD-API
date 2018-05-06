package com.depromeet.schedule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.common.entity.Code;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id", nullable = false)
	private Long subjectId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_category", nullable = false)
	private Code subjectCategory;

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Code getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(Code subjectCategory) {
		this.subjectCategory = subjectCategory;
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
}
