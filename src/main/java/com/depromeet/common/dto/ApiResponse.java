package com.depromeet.common.dto;

public class ApiResponse<T> {
	
	private T data;
	private Boolean isLeader;
	
	public ApiResponse() {
	}
	
	public ApiResponse(T data) {
		setData(data);
	}
	
	public ApiResponse(Boolean isLeader) {
		setIsLeader(isLeader);
	}
	
	public ApiResponse(T data, Boolean isLeader) {
		setData(data);
		setIsLeader(isLeader);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Boolean getIsLeader() {
		return isLeader;
	}
	
	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}
}
