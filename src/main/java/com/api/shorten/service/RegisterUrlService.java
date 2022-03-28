package com.api.shorten.service;

import com.api.shorten.dto.RegisterUrlRequestDto;
import com.api.shorten.dto.RegisterUrlResponseDto;
import com.api.shorten.exception.*;

public interface RegisterUrlService {
		
    
	 RegisterUrlResponseDto registerUrl(RegisterUrlRequestDto dtoRequest) throws ShortenException; 
	

}
