package com.api.shorten.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class ShortenException extends Exception {

	
	private static final long serialVersionUID = 1280541344472181599L;
	
	public HttpStatus status;
	
	public ShortenException(String message, HttpStatus httpStatus) {		
		super(message);
		this.status = httpStatus;
	
	}
	

}
