package com.testgcp.news.service;

import java.util.List;

import com.testgcp.news.service.dto.DtoIntDataArticle;
import com.testgcp.news.service.dto.DtoIntFilter;

public interface InternationalNewsService {

	DtoIntDataArticle getArticles(DtoIntFilter filter);
	
	List<DtoIntDataArticle> getBreakNewsInternational();
}
