package com.testgcp.news.service.utility;

import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.testgcp.news.service.dto.DtoIntFilter;

public class ServiceUtilityTest {

	@Test
	public void buildQueryParamsNull() {
		final Map<String, String> queryParams = ServiceUtility.buildQueryParamsArticles(null);
		Assert.assertNull(queryParams);
	}

	@Test
	public void buildQueryParams() {
		final DtoIntFilter filter = DtoIntFilter.builder().content("content").pageSize("1").title("title").build();
		final Map<String, String> queryParams = ServiceUtility.buildQueryParamsArticles(filter);
		Assert.assertEquals(queryParams.get("in"), "title,content");
		Assert.assertEquals(queryParams.get("max"), filter.getPageSize());
		Assert.assertEquals(queryParams.get("q"), filter.getContent());
	}
	
	@Test
	public void buildQueryParamsTopicsNull() {
		final Map<String, String> queryParams = ServiceUtility.buildQueryParamsTopics(null);
		Assert.assertNull(queryParams);
	}

	@Test
	public void buildQueryParamsTopics() {
		final Map<String, String> queryParams = ServiceUtility.buildQueryParamsTopics("us");
		Assert.assertEquals(queryParams.get("country"), "us");
	}
}
