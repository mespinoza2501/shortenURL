package com.api.shorten.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shorten.dto.StatisticAccessUrlResponseDto;
import com.api.shorten.model.LogAccessUrl;
import com.api.shorten.repositry.LogAccessUrlRepository;
import com.api.shorten.service.StatisticAccessUrlService;

@Service
public class StatisticAccessUrlServiceImpl implements  StatisticAccessUrlService {

	
	
	@Autowired
	private LogAccessUrlRepository logAccessUrlRepository;
	
	
	@Override
	public StatisticAccessUrlResponseDto processStatisticUrlAccess(String code) {
		
		try {
			List<LogAccessUrl> logsAccess =  logAccessUrlRepository.findByCode(code);
			StatisticAccessUrlResponseDto dto = StatisticAccessUrlResponseDto.builder().build();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/y hh:mm:ss");
			
			dto.setQtAccess(logsAccess.stream().count());		
			dto.setLastAccess(logsAccess.stream().map(e -> e.getDateAccess()).max(LocalDateTime::compareTo).get().format(formatter));
			
			
			return dto;
			
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();

		}
		
		
		return null;
	
		
	}

}
