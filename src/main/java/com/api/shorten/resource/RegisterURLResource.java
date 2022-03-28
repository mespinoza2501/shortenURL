package com.api.shorten.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shorten.dto.RegisterUrlRequestDto;
import com.api.shorten.dto.RegisterUrlResponseDto;
import com.api.shorten.exception.ShortenException;
import com.api.shorten.service.RegisterUrlService;


@RestController
public class RegisterURLResource {
	
	
	
	@Autowired
	private RegisterUrlService service;
	
	@PostMapping(path = "/register")
	public ResponseEntity<RegisterUrlResponseDto> registerUrl(@RequestBody RegisterUrlRequestDto dto ) throws ShortenException{		
		return ResponseEntity
				.ok(service.registerUrl(dto));
	}

}
