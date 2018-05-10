package com.depromeet.schedule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.member.entity.Member;

@Entity
public class Study {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "study_id", nullable = false)
	private Long studyId;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "leader", nullable = false)
	private Member leader;
	
	public Long getStudyId() {
		return studyId;
	}
	
	public void setStudyId(Long studyId) {
		this.studyId = studyId;
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
	
	public Member getLeader() {
		return leader;
	}
	
	public void setLeader(Member leader) {
		this.leader = leader;
	}
}
