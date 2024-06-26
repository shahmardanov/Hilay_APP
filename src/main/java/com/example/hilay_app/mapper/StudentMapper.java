package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.response.create.StudentCreateResponse;
import com.example.hilay_app.response.login.StudentLoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    Student mapCreateRequestToStudent(StudentCreateRequest studentCreateRequest);
    StudentCreateResponse mapStudentToCreateResponse(Student student);

    StudentLoginResponse mapStudentToLoginResponse(Student student);
}