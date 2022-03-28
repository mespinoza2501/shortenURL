package com.api.shorten.feign;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.api.shorten.dto.CacheUrlRequestDto;
import com.api.shorten.dto.CacheUrlResponseDto;

@FeignClient(name = "cacheFeign", url = "${cacheExternal.url}")
public interface CacheFeign {
	
	
	
	@GetMapping(path = "/cache/{id}", consumes = "application/json")	
	CacheUrlResponseDto consultCache(
			@PathVariable(value = "id") String id,
			@RequestHeader(required = true, value = "Accept" , defaultValue = "*/*") String accept
			); 
	
	
	@PostMapping(path = "/cache")
	void persistCacheUrl(@RequestBody CacheUrlRequestDto dto);

}
