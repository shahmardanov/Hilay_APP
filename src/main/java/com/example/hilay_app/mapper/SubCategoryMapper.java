package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.SubCategory;
import com.example.hilay_app.request.create.SubCategoryCreateRequest;
import com.example.hilay_app.request.update.SubCategoryUpdateRequest;
import com.example.hilay_app.response.create.SubCategoryCreateResponse;
import com.example.hilay_app.response.read.SubCategoryReadResponse;
import com.example.hilay_app.response.update.SubCategoryUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SubCategoryMapper {


    SubCategory toEntity(SubCategoryCreateRequest request);
    SubCategoryCreateResponse toCreateResponse(SubCategory subCategory);


    SubCategoryReadResponse toReadResponse(SubCategory subCategory);


    SubCategoryUpdateResponse toUpdateResponse(SubCategory subCategory);
    void updateEntityFromRequest(SubCategoryUpdateRequest request, @MappingTarget SubCategory subCategory);

}
