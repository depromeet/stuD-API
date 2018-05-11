package com.depromeet.common.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.depromeet.common.dto.ApiErrorResponse;

@RestControllerAdvice
public class ApiResponseExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponse handleNoSuchElementException(Exception ex) {
		return new ApiErrorResponse(ex.getMessage());
	}
}
