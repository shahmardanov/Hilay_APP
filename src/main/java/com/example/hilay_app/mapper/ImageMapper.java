package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Image;
import com.example.hilay_app.response.read.ImageReadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ImageMapper {

    Image toEntity(ImageCreateRequest request);
  //  ImageCreateResponse toResponseFromEntity(Image entity);

    ImageReadResponse entityToImageReadResponse(Image image);

    void mapForUpdate(@MappingTarget Image image, ImageUpdateRequest imageUpdateRequest);
    ImageUpdateResponse toUpdateResponse(Image image);


}
