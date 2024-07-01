package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Answers;
import com.example.hilay_app.request.create.AnswersCreateRequest;
import com.example.hilay_app.request.update.AnswersUpdateRequest;
import com.example.hilay_app.response.create.AnswersCreateResponse;
import com.example.hilay_app.response.read.AnswersReadResponse;
import com.example.hilay_app.response.update.AnswersUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    Answers toEntity(AnswersCreateRequest request);

    AnswersCreateResponse toCreateResponse(Answers answer);

    AnswersReadResponse toReadResponse(Answers answer);

    Answers toEntity(AnswersUpdateRequest request);

    AnswersUpdateResponse toUpdateResponse(Answers answer);

    void updateFromRequest(@MappingTarget Answers answer, AnswersUpdateRequest request);
}
