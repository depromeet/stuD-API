package com.depromeet.member.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<Member> members;
	
	@ManyToMany
	@JoinTable(
			name = "privileges",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "previlige_id"))
	private Collection<Previlige> previliges;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Member> getMembers() {
		return members;
	}

	public void setMembers(Collection<Member> members) {
		this.members = members;
	}

	public Collection<Previlige> getPreviliges() {
		return previliges;
	}

	public void setPreviliges(Collection<Previlige> previliges) {
		this.previliges = previliges;
	}
}
