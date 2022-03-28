package com.api.shorten.resource;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.shorten.dto.StatisticAccessUrlResponseDto;
import com.api.shorten.service.RecouverUrlService;
import com.api.shorten.service.StatisticAccessUrlService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class StatisticResourceTest {
	
	
	@Autowired
	private StatisticResource statisticResource;
	
	
	@MockBean(name = "serviceTest")
	private StatisticAccessUrlService statisticAccessUrlService;
	
	
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.statisticResource);
	}
	
	
	@Test
	public void returnSuccess_When_consultStatisticAccess() {
		
	
	}

}
