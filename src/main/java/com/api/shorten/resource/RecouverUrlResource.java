package com.api.shorten.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.api.shorten.exception.ShortenException;
import com.api.shorten.service.RecouverUrlService;

@RestController
public class RecouverUrlResource {
	
	
	
	@Autowired
	private RecouverUrlService recouverUrlService;

	@GetMapping(path = "/{id}")
	public void recouverURL(@PathVariable("id") String id, HttpServletResponse httpResponse) throws IOException, ShortenException {
		httpResponse.sendRedirect(recouverUrlService.recouverUrlShorten(id));
	}

}
