package com.api.shorten.service;

import com.api.shorten.dto.CacheUrlRequestDto;
public interface CacheUrlService {
	
	void persistCache(CacheUrlRequestDto dto);
	

}
