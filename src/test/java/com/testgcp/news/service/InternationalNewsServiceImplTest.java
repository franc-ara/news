package com.testgcp.news.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.testgcp.news.service.dto.DtoIntDataArticle;
import com.testgcp.news.service.dto.DtoIntFilter;
import com.testgcp.news.service.impl.InternationalNewsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class InternationalNewsServiceImplTest {

	@InjectMocks
	private InternationalNewsServiceImpl service;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private Gson gson;

	@Test
	public void getArticlesTest() {
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.eq(null),
				Mockito.eq(String.class), Mockito.anyMap()))
				.thenReturn(new ResponseEntity<String>("{}", HttpStatus.OK));
		Mockito.when(gson.fromJson(Mockito.anyString(), Mockito.any())).thenReturn(new DtoIntDataArticle());

		service.getArticles(DtoIntFilter.builder().content("content").title("title").pageSize("10").build());

		Mockito.verify(restTemplate).exchange(Mockito.anyString(), Mockito.any(), Mockito.eq(null),
				Mockito.eq(String.class), Mockito.anyMap());
		Mockito.verify(gson).fromJson(Mockito.anyString(), Mockito.any());
	}
	
	@Test
	public void getBreakNewsInternational() {
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.eq(null),
				Mockito.eq(String.class), Mockito.anyMap()))
				.thenReturn(new ResponseEntity<String>("{}", HttpStatus.OK));
		Mockito.when(gson.fromJson(Mockito.anyString(), Mockito.any())).thenReturn(new DtoIntDataArticle());

		service.getBreakNewsInternational();

		Mockito.verify(restTemplate,Mockito.times(5)).exchange(Mockito.anyString(), Mockito.any(), Mockito.eq(null),
				Mockito.eq(String.class), Mockito.anyMap());
		Mockito.verify(gson,Mockito.times(5)).fromJson(Mockito.anyString(), Mockito.any());
	}

}
