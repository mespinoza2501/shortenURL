package com.api.shorten.service;

import com.api.shorten.exception.ShortenException;

public interface RecouverUrlService {
	
	
	
	String recouverUrlShorten(String code) throws ShortenException;

}
