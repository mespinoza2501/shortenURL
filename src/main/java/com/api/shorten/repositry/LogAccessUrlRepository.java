package com.api.shorten.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shorten.model.LogAccessUrl;

public interface LogAccessUrlRepository extends  JpaRepository<LogAccessUrl, Long>{
	
	
	
	List<LogAccessUrl> findByCode(String code);
	

}
