package com.depromeet.schedule.enums;

public enum AttendanceCode {
	
	ATTEND(1L, "참석"), LATE(2L, "지각"), NOT_ATTEND(3L, "불참");
	
	public Long code;
	public String value;
	
	AttendanceCode(Long code, String value) {
		this.code = code;
		this.value = value;
	}
	
	public Long getCode() {
		return code;
	}
	
	public String getValue() {
		return value;
	}
}
