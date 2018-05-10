package com.depromeet.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApiError {

	public static final int CODE_NOT_EXIST_MEMBER = 40001;
	public static final int CODE_NOT_EXIST_STUDY = 40002;
	public static final int CODE_ATTENDANCE_ALREADY_DECIDED = 40010;
	public static final int CODE_UNAUTHORIZED = 40101;
	
	private int code;
	private String message;
	
	public ApiError() {
	}
	
	public ApiError(String message) {
		setMessage(message);
	}
	
	public ApiError(int code, String message) {
		setCode(code);
		setMessage(message);
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
