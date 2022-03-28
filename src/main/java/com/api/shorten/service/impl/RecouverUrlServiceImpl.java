package com.api.shorten.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.api.shorten.dto.CacheUrlRequestDto;
import com.api.shorten.dto.CacheUrlResponseDto;
import com.api.shorten.exception.ShortenException;
import com.api.shorten.feign.CacheFeign;
import com.api.shorten.model.LogAccessUrl;
import com.api.shorten.model.UrlShorten;
import com.api.shorten.repositry.UrlShortenRepository;
import com.api.shorten.service.RecouverUrlService;

import feign.FeignException;



@Service
public class RecouverUrlServiceImpl implements RecouverUrlService {

	
	@Autowired
	private CacheFeign cacheFeign;
	
	@Autowired
	private UrlShortenRepository urlShortenRepository;
	

	@Autowired
	private ApplicationEventPublisher publisher;
	

	@Override
	public String recouverUrlShorten(String code) throws ShortenException {	

		
		
		//log ce acesso
		publisher.publishEvent(LogAccessUrl.builder()
								.code(code)
								.dateAccess(LocalDateTime.now())
								.build());
		try {
			CacheUrlResponseDto dto = cacheFeign.consultCache(code, "*/*");
			if(dto.getUrl() != null) {
				return dto.getUrl();
			}
		} catch (FeignException e) {			
			e.getMessage();
		}
		Optional<UrlShorten> urlShoten = urlShortenRepository.findByCodeUrl(code).stream().findFirst();
		System.out.println("Buscando registro no DB");
		if (urlShoten.isPresent()){			
			
			//incluido url no cache
			publisher.publishEvent(CacheUrlRequestDto.builder()
									.id(code)
									.url(urlShoten.get().getUrlReference())
									.build());
			return urlShoten.get().getUrlReference();
		}

		return null;
	}

}
