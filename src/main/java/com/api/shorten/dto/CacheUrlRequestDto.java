package com.api.shorten.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CacheUrlRequestDto implements Serializable {
	
	
	private static final long serialVersionUID = 7839634555809659526L;
	
	private String id;
	private String url;
	
	

}
