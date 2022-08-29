package com.testgcp.news.service.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DtoIntArticle implements Serializable{

	private static final long serialVersionUID = 1L;
	public String title;
	public String description;
	public String content;
	public String url;
	public String image;
	public Date publishedAt;
	public DtoIntSource source;
}
