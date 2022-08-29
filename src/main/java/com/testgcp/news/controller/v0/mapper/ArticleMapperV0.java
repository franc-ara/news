package com.testgcp.news.controller.v0.mapper;

import org.mapstruct.Mapper;

import com.testgcp.news.constant.Constant;
import com.testgcp.news.controller.v0.dto.DtoArticle;
import com.testgcp.news.service.dto.DtoIntArticle;

@Mapper(componentModel = Constant.SPRING, implementationPackage = Constant.CONTROLLER_MAPPER)
public interface ArticleMapperV0 {

	DtoIntArticle mapInner(DtoArticle in);

	DtoArticle mapOuter(DtoIntArticle out);
}
