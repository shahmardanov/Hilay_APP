package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.UserAnswers;
import com.example.hilay_app.request.create.UserAnswersCreateRequest;
import com.example.hilay_app.response.create.UserAnswersCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserAnswersMapper {
    UserAnswers toEntity(UserAnswersCreateRequest request);
    UserAnswersCreateResponse toResponse(UserAnswers userAnswers);
}
