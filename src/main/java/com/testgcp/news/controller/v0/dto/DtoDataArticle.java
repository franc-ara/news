package com.testgcp.news.controller.v0.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class DtoDataArticle {

	private int totalArticles;
	private ArrayList<DtoArticle> articles;

}