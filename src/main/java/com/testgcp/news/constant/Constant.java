package com.testgcp.news.constant;

public class Constant {

	private Constant() {
		throw new IllegalStateException();
	}

	/* The token value must store in DB and get value for each environment*/
	public static final String API_KEY = "43eaacca9a4d89fd988ec378312ceffe";
	/* The URL's value must store in DB and get value for each environment */
	public static final String API_GNEWS_ARTICLES = "https://gnews.io/api/v4/search?q={q}&lang={lang}&max={max}&in={in}&token={token}&from={from}&to={to}&token={token}";
	public static final String API_GNEWS_URL_TOPICS = "https://gnews.io/api/v4/top-headlines?token={token}&topic={topic}&lang={lang}&country={country}&max={max}";
	public static final String SPRING = "spring";
	public static final String CONTROLLER_MAPPER = "com.testgcp.news.controller.v0.mapper.impl";

}
