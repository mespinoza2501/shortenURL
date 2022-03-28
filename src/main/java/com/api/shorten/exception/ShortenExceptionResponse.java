package com.api.shorten.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortenExceptionResponse implements Serializable{


	private static final long serialVersionUID = -8959418252871205553L;
	
	private String message;

}
