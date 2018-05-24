package com.depromeet.member.dto;

import java.sql.Date;

public class MemberScheduleDto {
	
	private String name;
	private Date startAt;
	private Boolean attended;
	private Boolean guest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	
	public Boolean isAttended() {
		return attended;
	}
	
	public void setAttended(Boolean attended) {
		this.attended = attended;
	}

	public Boolean isGuest() {
		return guest;
	}

	public void setGuest(Boolean guest) {
		this.guest = guest;
	}
}
