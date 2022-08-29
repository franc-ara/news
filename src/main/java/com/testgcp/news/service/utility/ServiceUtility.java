package com.testgcp.news.service.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.testgcp.news.constant.Constant;
import com.testgcp.news.service.dto.DtoIntFilter;

public class ServiceUtility {

	private ServiceUtility() {
		throw new IllegalStateException();
	}

	private static final String TOKEN_API_PARAM = "token";
	private static final String PORPUSE_PARAM = "q";
	private static final String TOPIC_PARAM = "topic";
	private static final String TOPIC_VALUE = "breaking-news";
	private static final String TITLE_PARAM = "in";
	private static final String INIT_DATE_PARAM = "from";
	private static final String END_DATE_PARAM = "to";
	private static final String PAGE_SIZE_PARAM = "max";
	private static final String LANG_PARAM = "lang";
	private static final String ENGLISH_VALUE = "en";
	private static final String COMA = ",";
	private static final String SORT_BY_PARAM = "sortby";
	private static final String SORT_BY_VALUE = "publishedAt";
	private static final String NUMBER_ONE = "1";
	private static final String COUNTRY_PARAM = "country";

	public static Map<String, String> buildQueryParamsArticles(DtoIntFilter filter) {
		if (Objects.isNull(filter)) {
			return null;
		}

		final Map<String, String> parameters = new HashMap<>();

		/*
		 * The method createInParam build a string with title and content because this
		 * words are possibles values in field "in"
		 */
		final StringBuilder titleParam = createInParam(filter);

		parameters.put(TOKEN_API_PARAM, Constant.API_KEY);
		parameters.put(PORPUSE_PARAM, filter.getContent());
		parameters.put(INIT_DATE_PARAM, filter.getInitDate());
		parameters.put(END_DATE_PARAM, filter.getEndDate());
		parameters.put(TITLE_PARAM, titleParam.toString());
		/* If pageSize is null or greater than 10 the API return max 10 elements */
		parameters.put(PAGE_SIZE_PARAM, filter.getPageSize());
		parameters.put(LANG_PARAM, ENGLISH_VALUE);
		/*
		 * This queryParam sorted by date, the most recent article has the first
		 * position
		 */
		parameters.put(SORT_BY_PARAM, SORT_BY_VALUE);

		return parameters;
	}

	private static StringBuilder createInParam(DtoIntFilter filter) {

		final StringBuilder sb = new StringBuilder();
		if (Objects.nonNull(filter.getTitle()) && !filter.getTitle().isBlank()) {
			sb.append(filter.getTitle());
		}
		if (sb.length() > 0) {
			sb.append(COMA);
		}
		if (Objects.nonNull(filter.getContent()) && !filter.getContent().isBlank()) {
			sb.append(filter.getContent());
		}
		return sb;
	}

	public static Map<String, String> buildQueryParamsTopics(String country) {
		if(Objects.isNull(country)) {
			return null;
		}
		
		final Map<String, String> parameters = new HashMap<>();

		parameters.put(TOKEN_API_PARAM, Constant.API_KEY);
		parameters.put(TOPIC_PARAM, TOPIC_VALUE);
		parameters.put(PAGE_SIZE_PARAM, NUMBER_ONE);
		parameters.put(LANG_PARAM, ENGLISH_VALUE);
		parameters.put(COUNTRY_PARAM, country);
		return parameters;
	}

}
