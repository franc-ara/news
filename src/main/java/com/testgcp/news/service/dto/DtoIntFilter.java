package com.testgcp.news.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DtoIntFilter {

	private String title;
	private String content;
	private String initDate;
	private String endDate;
	private String pageSize;

}
