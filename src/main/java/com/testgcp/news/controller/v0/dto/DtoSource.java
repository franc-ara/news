package com.testgcp.news.controller.v0.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DtoSource implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public String url;
}