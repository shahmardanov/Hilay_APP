package com.example.hilay_app.mapper;


import com.example.hilay_app.entity.QuestionsLevel;
import com.example.hilay_app.request.create.QuestionsLevelCreateRequest;
import com.example.hilay_app.request.update.QuestionsLevelUpdateRequest;
import com.example.hilay_app.response.create.QuestionsLevelCreateResponse;
import com.example.hilay_app.response.read.QuestionsLevelReadResponse;
import com.example.hilay_app.response.update.QuestionsLevelUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface QuestionsLevelMapper {

    QuestionsLevel toEntity(QuestionsLevelCreateRequest questionsLevelCreateRequest);

    QuestionsLevelCreateResponse toResponse(QuestionsLevel questionsLevel);

    QuestionsLevelReadResponse toLevelReadResponse(QuestionsLevel questionsLevel);

    QuestionsLevelUpdateResponse toLevelUpdateResponse(QuestionsLevel questionsLevel);

    void questionsLevelUpdateFromRequest(QuestionsLevelUpdateRequest updateRequest, @MappingTarget QuestionsLevel questionsLevel);
}