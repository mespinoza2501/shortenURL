package com.api.shorten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.shorten.dto.CacheUrlRequestDto;
import com.api.shorten.feign.CacheFeign;
import com.api.shorten.service.CacheUrlService;

@Service
public class CacheUrlServiceImpl implements CacheUrlService {

	@Autowired
	private CacheFeign cacheFeign;

	@EventListener
	@Async
	@Override
	public void persistCache(CacheUrlRequestDto dto) {
		System.out.println("Persistindo cacche");
		if (dto != null) {
			try {
				cacheFeign.persistCacheUrl(dto);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
