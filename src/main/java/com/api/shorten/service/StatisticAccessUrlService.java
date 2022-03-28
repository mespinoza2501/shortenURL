package com.api.shorten.service;

import com.api.shorten.dto.StatisticAccessUrlResponseDto;

public interface StatisticAccessUrlService {
	
	
	StatisticAccessUrlResponseDto processStatisticUrlAccess(String code);

}
