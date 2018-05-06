package com.depromeet.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApiResponse<T> {
	
	private T data;
	private ApiError error;
	
	public ApiResponse() {
	}
	
	public ApiResponse(T data) {
		setData(data);
	}
	
	public ApiResponse(ApiError error) {
		setError(error);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public ApiError getError() {
		return error;
	}
	
	public void setError(ApiError error) {
		this.error = error;
	}
}
