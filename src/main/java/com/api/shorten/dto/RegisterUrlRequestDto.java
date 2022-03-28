package com.api.shorten.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUrlRequestDto implements Serializable {
	
	

	private static final long serialVersionUID = 1085980938563671770L;
	
	@JsonProperty(required = true)
	private String url;

}
