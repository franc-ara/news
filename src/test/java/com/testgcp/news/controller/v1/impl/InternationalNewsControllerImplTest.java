package com.testgcp.news.controller.v1.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testgcp.news.controller.v0.dto.DtoDataArticle;
import com.testgcp.news.controller.v0.impl.InternationalNewsControllerImpl;
import com.testgcp.news.controller.v0.mapper.DataArticleMapperV0;
import com.testgcp.news.service.dto.DtoIntDataArticle;
import com.testgcp.news.service.impl.InternationalNewsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class InternationalNewsControllerImplTest {

	@InjectMocks
	private InternationalNewsControllerImpl controller;

	@Mock
	private InternationalNewsServiceImpl service;

	@Mock
	private DataArticleMapperV0 mapper;

	@Test
	public void getArticles() {
		Mockito.when(service.getArticles(Mockito.any())).thenReturn(new DtoIntDataArticle());
		Mockito.when(mapper.mapOuter(Mockito.any())).thenReturn(new DtoDataArticle());

		controller.getArticles("title", "content", "2002-01-01", "2020-02-02", "2");
		
		Mockito.verify(mapper).mapOuter(Mockito.any());
		Mockito.verify(service).getArticles(Mockito.any());
	}

	@Test
	public void getBreakingNewsInternational() {
		final List<DtoIntDataArticle> data = new ArrayList<>();
		data.add(new DtoIntDataArticle());
		Mockito.when(service.getBreakNewsInternational()).thenReturn(data);
		Mockito.when(mapper.mapOuter(Mockito.any())).thenReturn(new DtoDataArticle());
		controller.getBreakingNewsInternational();
		Mockito.verify(mapper, Mockito.atLeast(1)).mapOuter(Mockito.any());
		Mockito.verify(service).getBreakNewsInternational();
	}
}
