package com.testgcp.news.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class DtoIntDataArticle implements Serializable{

	private static final long serialVersionUID = 1L;
	private int totalArticles;
	private ArrayList<DtoIntArticle> articles;

}