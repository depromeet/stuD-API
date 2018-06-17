package com.depromeet.member.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Previlige {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long previligeId;
	
	private String name;
	
	@ManyToMany(mappedBy = "previliges")
	private Collection<Role> roles;

	public Long getPreviligeId() {
		return previligeId;
	}

	public void setPreviligeId(Long previligeId) {
		this.previligeId = previligeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
