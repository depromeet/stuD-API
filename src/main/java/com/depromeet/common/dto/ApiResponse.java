package com.depromeet.common.dto;

public class ApiResponse<T> {
	
	private T data;
	
	public ApiResponse() {
	}
	
	public ApiResponse(T data) {
		setData(data);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
