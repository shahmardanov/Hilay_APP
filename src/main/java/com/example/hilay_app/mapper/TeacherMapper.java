package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Teacher;
import com.example.hilay_app.request.create.TeacherCreateRequest;
import com.example.hilay_app.request.update.TeacherUpdateRequest;
import com.example.hilay_app.response.create.TeacherCreateResponse;
import com.example.hilay_app.response.read.TeacherReadResponse;
import com.example.hilay_app.response.update.TeacherUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
    Teacher toTeacher(TeacherCreateRequest request);

    TeacherCreateResponse toCreateResponse(Teacher teacher);

    TeacherReadResponse toReadResponse(Teacher teacher);

    TeacherUpdateResponse toUpdateResponse(Teacher teacher);


    void updateTeacherFromRequest(TeacherUpdateRequest request, @MappingTarget Teacher teacher);
}
