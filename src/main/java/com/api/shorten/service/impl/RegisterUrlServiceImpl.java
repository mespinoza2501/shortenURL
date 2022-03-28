package com.api.shorten.service.impl;



import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.shorten.dto.RegisterUrlRequestDto;
import com.api.shorten.dto.RegisterUrlResponseDto;
import com.api.shorten.exception.ShortenException;
import com.api.shorten.model.UrlShorten;
import com.api.shorten.repositry.UrlShortenRepository;
import com.api.shorten.service.RegisterUrlService;
import com.api.shorten.util.ShotenUtil;

@Service
public class RegisterUrlServiceImpl implements RegisterUrlService {

	@Value("${application.context}")
	private String applicationContext;

	@Autowired
	private UrlShortenRepository urlShortenRepository;

	@Override
	public RegisterUrlResponseDto registerUrl(RegisterUrlRequestDto dtoRequest) throws ShortenException {

		try {

			validationBody(dtoRequest);
			urlValidation(dtoRequest.getUrl());

			UrlShorten urlShorten = urlShortenRepository.save(UrlShorten.builder().registrationDate(LocalDateTime.now())
					.urlReference(dtoRequest.getUrl()).codeUrl(generationCodeUrl()).build());

			return RegisterUrlResponseDto.builder().urlShorten(applicationContext + urlShorten.getCodeUrl()).build();
		} catch (Exception e) {
			throw new ShortenException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	private void validationBody(RegisterUrlRequestDto body) throws ShortenException {
		
			
		if (body.getUrl() == null) {
			throw new ShortenException("Url deve ser informada", HttpStatus.BAD_REQUEST);
		}
	
		
		if(body.getUrl().trim().isEmpty()) {
			throw new ShortenException("Url deve ser informada", HttpStatus.BAD_REQUEST);
		}
		
		

		
		

	}
	
	private void urlValidation(String urlRequest) throws ShortenException {
		
		
		
		try {
			
			URL url =  new URL(urlRequest);
			url.openStream().close();
		
			
		} catch (Exception e) {
			throw new ShortenException("Url inválida", HttpStatus.BAD_REQUEST);
		}
			
	}

	private String generationCodeUrl() throws ShortenException {
		boolean isCodeInDataBase = true;
		String codeUrl = null;
		try {

			// valida para não incluir codigo duplicado
			while (isCodeInDataBase) {
				codeUrl = ShotenUtil.randomGenerationCode();
				List<UrlShorten> urlsShortens = urlShortenRepository.findByCodeUrl(codeUrl);
				if (urlsShortens.size() == 0) {
					isCodeInDataBase = false;
				}

			}

		} catch (Exception e) {
			throw new ShortenException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return codeUrl;
	}

}
