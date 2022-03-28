package com.api.shorten.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shorten.model.UrlShorten;

@Repository
public interface UrlShortenRepository extends JpaRepository<UrlShorten, Long> {
	
	
	
	List<UrlShorten> findByCodeUrl(String codeUrl);

}
