package com.api.shorten.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.shorten.dto.StatisticAccessUrlResponseDto;
import com.api.shorten.service.StatisticAccessUrlService;

@RestController
public class StatisticResource {
	
	
	@Autowired
	private StatisticAccessUrlService statisticAccessUrlService;
	
	
	
	@GetMapping(path = "/{id}/statistic")
	public ResponseEntity<StatisticAccessUrlResponseDto> statisticAccessUrl(@PathVariable("id") String id){		
		StatisticAccessUrlResponseDto response = statisticAccessUrlService.processStatisticUrlAccess(id);
		return response ==  null ? ResponseEntity.status(404).build() : ResponseEntity.status(200).body(response);
	}
	

}
