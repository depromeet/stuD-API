package com.depromeet.common.dto;

public class ApiErrorResponse {
	
	private ApiError error;
	
	public ApiErrorResponse() {
	}
	
	public ApiErrorResponse(ApiError error) {
		setError(error);
	}
	
	public ApiErrorResponse(String errorMessage) {
		setError(new ApiError(errorMessage));
	}
	
	public ApiError getError() {
		return error;
	}
	
	public void setError(ApiError error) {
		this.error = error;
	}
}
