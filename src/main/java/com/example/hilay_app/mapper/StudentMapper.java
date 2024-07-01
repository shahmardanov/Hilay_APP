package com.example.hilay_app.mapper;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.request.StudentProfileRequest;
import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.request.create.StudentTeacherRequest;
import com.example.hilay_app.request.update.StudentProfileUpdateRequest;
import com.example.hilay_app.response.StudentProfileResponse;
import com.example.hilay_app.response.create.StudentCreateResponse;
import com.example.hilay_app.response.create.StudentTeacherResponse;
import com.example.hilay_app.response.login.StudentLoginResponse;
import com.example.hilay_app.response.update.StudentProfileUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    Student mapCreateRequestToStudent(StudentCreateRequest studentCreateRequest);
    StudentCreateResponse mapStudentToCreateResponse(Student student);

    StudentLoginResponse mapStudentToLoginResponse(Student student);

    Student mapStudentProfileToEntity(StudentProfileRequest profileRequest);
    StudentProfileResponse mapEntityToStudentProfile(Student student);

    StudentProfileUpdateResponse toUpdateResponse(Student student);

    Student teacherRequestToEntity(StudentTeacherRequest teacherRequest);

    StudentTeacherResponse entityMapToTeacherResponse(Student student);

    void update(@MappingTarget Student student, StudentProfileUpdateRequest studentProfileUpdateRequest);
}
