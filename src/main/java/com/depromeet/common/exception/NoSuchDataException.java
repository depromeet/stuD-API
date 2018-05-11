package com.depromeet.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchDataException extends RuntimeException {
	
	private static final long serialVersionUID = -2940757694525632645L;
	
	public NoSuchDataException() {
		super();
	}
	
	public NoSuchDataException(String message) {
		super(message);
	}
}
