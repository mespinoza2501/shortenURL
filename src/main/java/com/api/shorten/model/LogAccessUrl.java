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
@Table(name = "LOG_ACCESS_URL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogAccessUrl implements  Serializable  {
	private static final long serialVersionUID = -4866627883325668711L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private LocalDateTime dateAccess;
	
	
	
	

}
