package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.MainCategory;
import com.example.hilay_app.request.create.MainCategoryCreateRequest;
import com.example.hilay_app.request.update.MainCategoryUpdateRequest;
import com.example.hilay_app.response.create.MainCategoryCreateResponse;
import com.example.hilay_app.response.read.MainCategoryReadResponse;
import com.example.hilay_app.response.update.MainCategoryUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MainCategoryMapper {

    MainCategory toMainCategory(MainCategoryCreateRequest request);

    MainCategoryCreateResponse toCreateResponse(MainCategory mainCategory);

    MainCategoryReadResponse toReadResponse(MainCategory mainCategory);

    MainCategoryUpdateResponse toUpdateResponse(MainCategory mainCategory);

    void updateMainCategoryFromRequest(MainCategoryUpdateRequest request, @MappingTarget MainCategory mainCategory);
}
