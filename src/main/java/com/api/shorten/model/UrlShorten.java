package com.api.shorten.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "URL_SHORTEN")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlShorten implements Serializable{
	
	private static final long serialVersionUID = -975341014608783346L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String urlReference;	
	private String codeUrl;
	private LocalDateTime registrationDate;
	
	

}
