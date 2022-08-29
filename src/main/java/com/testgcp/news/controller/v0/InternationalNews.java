package com.testgcp.news.controller.v0;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.testgcp.news.controller.v0.dto.DtoDataArticle;

public interface InternationalNews {

	ResponseEntity<DtoDataArticle> getArticles(String title, String content, String initDate, String endDate,
			String pageSize);

	ResponseEntity<List<DtoDataArticle>> getBreakingNewsInternational();

}
