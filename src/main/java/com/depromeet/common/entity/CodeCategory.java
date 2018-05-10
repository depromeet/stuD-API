package com.depromeet.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodeCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code_category_id", nullable = false)
	private Long codeCategoryId;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;

	public Long getCodeCategoryId() {
		return codeCategoryId;
	}

	public void setCodeCategoryId(Long codeCategoryId) {
		this.codeCategoryId = codeCategoryId;
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
}
