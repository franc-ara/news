package com.testgcp.news.controller.v0.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DtoArticle implements Serializable{

	private static final long serialVersionUID = 1L;
	public String title;
	public String description;
	public String content;
	public String url;
	public String image;
	public Date publishedAt;
	public DtoSource source;
}
