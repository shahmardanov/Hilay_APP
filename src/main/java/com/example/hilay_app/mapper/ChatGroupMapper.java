package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.ChatGroup;
import com.example.hilay_app.request.create.ChatGroupCreateRequest;
import com.example.hilay_app.response.create.ChatGroupCreateResponse;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ChatGroupMapper {

    ChatGroup toEntity(ChatGroupCreateRequest request);

    ChatGroupCreateResponse toCreateResponse(ChatGroup entity);

//    ChatGroupReadResponse toReadResponse(ChatGroup entity);
//
//    ChatGroupUpdateResponse toUpdateResponse(ChatGroup entity);
//
//
//    void updateEntityFromRequest(@MappingTarget ChatGroup entity, ChatGroupUpdateRequest request);
}
