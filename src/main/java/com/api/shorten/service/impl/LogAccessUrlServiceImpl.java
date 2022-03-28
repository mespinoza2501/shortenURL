package com.api.shorten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.shorten.model.LogAccessUrl;
import com.api.shorten.repositry.LogAccessUrlRepository;

@Service
public class LogAccessUrlServiceImpl {

	@Autowired
	private LogAccessUrlRepository logAccessUrlRepository;
	
	
	@Async
	@EventListener	
	public void createLogAccessUrl(LogAccessUrl log) {
		System.out.println("Publicando evento");
		logAccessUrlRepository.save(log);
	}
	
	
	
}
