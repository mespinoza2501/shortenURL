package com.api.shorten.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class StatisticAccessUrlResponseDto implements Serializable{


	private static final long serialVersionUID = 4324631903317380350L;
	
	
	private Long qtAccess;
	private String lastAccess; 

}
