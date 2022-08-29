package com.testgcp.news.controller.v0.mapper;

import org.mapstruct.Mapper;

import com.testgcp.news.constant.Constant;
import com.testgcp.news.controller.v0.dto.DtoDataArticle;
import com.testgcp.news.service.dto.DtoIntDataArticle;

@Mapper(componentModel = Constant.SPRING, implementationPackage = Constant.CONTROLLER_MAPPER)
public interface DataArticleMapperV0 {

	DtoIntDataArticle mapInner(DtoDataArticle in);

	DtoDataArticle mapOuter(DtoIntDataArticle out);
}
