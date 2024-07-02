package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Questions;
import com.example.hilay_app.request.update.QuestionsUpdateRequest;
import com.example.hilay_app.response.create.QuestionsCreateResponse;
import com.example.hilay_app.response.read.QuestionsReadResponse;
import com.example.hilay_app.response.update.QuestionsUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface QuestionsMapper {

    QuestionsCreateResponse toResponse(Questions questions);

  //  Questions toEntity(QuestionsCreateRequest questionsCreateRequest);

    QuestionsUpdateResponse toUpdateResponse(Questions questions);
    QuestionsReadResponse toReadResponse(Questions questions);


    void mapForUpdate(@MappingTarget Questions questions, QuestionsUpdateRequest questionsUpdateRequest);
}