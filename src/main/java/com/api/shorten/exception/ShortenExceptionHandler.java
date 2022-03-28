package com.api.shorten.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ShortenExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
	@ExceptionHandler(value = {ShortenException.class})
	public ResponseEntity<?> handlerShortenException(ShortenException ex){
		return ResponseEntity.status(ex.getStatus()).body(ShortenExceptionResponse.builder()
														   .message(ex.getMessage())
														   .build());
	}

}
