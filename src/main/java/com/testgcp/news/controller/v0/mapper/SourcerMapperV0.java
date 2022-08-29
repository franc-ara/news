package com.testgcp.news.controller.v0.mapper;

import org.mapstruct.Mapper;

import com.testgcp.news.constant.Constant;
import com.testgcp.news.controller.v0.dto.DtoSource;
import com.testgcp.news.service.dto.DtoIntSource;

@Mapper(componentModel = Constant.SPRING, implementationPackage = Constant.CONTROLLER_MAPPER)
public interface SourcerMapperV0 {

	DtoIntSource mapInner(DtoSource in);

	DtoSource mapOuter(DtoIntSource out);
}
