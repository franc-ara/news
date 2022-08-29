package com.testgcp.news.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.testgcp.news.constant.Constant;
import com.testgcp.news.service.InternationalNewsService;
import com.testgcp.news.service.dto.DtoIntDataArticle;
import com.testgcp.news.service.dto.DtoIntFilter;
import com.testgcp.news.service.utility.ServiceUtility;

@Service
public class InternationalNewsServiceImpl implements InternationalNewsService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Gson gson;

	private static final String US = "us";
	private static final String RU = "ru";
	private static final String UA = "ua";
	private static final String CA = "ca";
	private static final String GB = "gb";

	@Override
	public DtoIntDataArticle getArticles(DtoIntFilter filter) {

		final Map<String, String> queryParams = ServiceUtility.buildQueryParamsArticles(filter);
		final String responseApi = restTemplate
				.exchange(Constant.API_GNEWS_ARTICLES, HttpMethod.GET, null, String.class, queryParams).getBody();
		return gson.fromJson(responseApi, DtoIntDataArticle.class);

	}

	@Override
	public List<DtoIntDataArticle> getBreakNewsInternational() {

		String[] countries = { UA, CA, GB, RU, US };
		List<DtoIntDataArticle> response = new ArrayList<>();
		try {
			for (int i = 0; countries.length > i; i++) {
				final Map<String, String> queryParams = ServiceUtility.buildQueryParamsTopics(countries[i]);
				final String responseApi = restTemplate
						.exchange(Constant.API_GNEWS_URL_TOPICS, HttpMethod.GET, null, String.class, queryParams)
						.getBody();
				final DtoIntDataArticle dataArticle = gson.fromJson(responseApi, DtoIntDataArticle.class);
				response.add(dataArticle);
				TimeUnit.MILLISECONDS.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
