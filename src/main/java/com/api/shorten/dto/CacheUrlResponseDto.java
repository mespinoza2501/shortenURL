package com.api.shorten.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CacheUrlResponseDto implements Serializable {
	
	
	private static final long serialVersionUID = -7455099954223716696L;
	
	private String url;
	

}
