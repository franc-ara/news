package com.testgcp.news.controller.v0.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testgcp.news.controller.v0.InternationalNews;
import com.testgcp.news.controller.v0.dto.DtoDataArticle;
import com.testgcp.news.controller.v0.mapper.DataArticleMapperV0;
import com.testgcp.news.service.InternationalNewsService;
import com.testgcp.news.service.dto.DtoIntFilter;

@RestController
@RequestMapping(path = "news/v0")
public class InternationalNewsControllerImpl implements InternationalNews {

	@Autowired
	private InternationalNewsService service;

	@Autowired
	private DataArticleMapperV0 dataArticleV0;

	@Override
	@GetMapping(path = "/articles")
	public ResponseEntity<DtoDataArticle> getArticles(@RequestParam(required = false) final String title,
			@RequestParam final String content, @RequestParam(required = false) final String initDate,
			@RequestParam(required = false) final String endDate,
			@RequestParam(required = false) final String pageSize) {

		final DtoIntFilter filter = DtoIntFilter.builder().title(title).content(content).initDate(initDate)
				.endDate(endDate).pageSize(pageSize).build();

		final DtoDataArticle dataArticle = dataArticleV0.mapOuter(service.getArticles(filter));
		return ResponseEntity.ok(dataArticle);
	}

	@Override
	@GetMapping(path = "/top-headlines")
	public ResponseEntity<List<DtoDataArticle>> getBreakingNewsInternational() {

		final List<DtoDataArticle> dataArticle = new ArrayList<>();

		service.getBreakNewsInternational().stream().forEach(element -> {
			dataArticle.add(dataArticleV0.mapOuter(element));
		});

		return ResponseEntity.ok(dataArticle);
	}

}
