package com.depromeet.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Code {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code_id", nullable = false)
	private Long codeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_category_id", nullable = false)
	private CodeCategory codeCategory;
	
	@Column(name = "value", length = 50, nullable = false)
	private String value;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

	public CodeCategory getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(CodeCategory codeCategory) {
		this.codeCategory = codeCategory;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
