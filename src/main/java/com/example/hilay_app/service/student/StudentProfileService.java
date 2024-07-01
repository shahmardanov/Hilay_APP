package com.example.hilay_app.service.student;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.exception.StudentNotFoundException;
import com.example.hilay_app.mapper.StudentMapper;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.StudentProfileRequest;
import com.example.hilay_app.response.StudentProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentProfileResponse profile(StudentProfileRequest studentProfileRequest) {
        Student existingStudent = studentRepository.findByUsername(studentProfileRequest.getUsername());
        if (existingStudent == null) {
            throw new StudentNotFoundException(HttpStatus.NOT_FOUND.name(),"User not found");
        }

        existingStudent.setFkImageId(studentProfileRequest.getFkImageId());
        existingStudent.setBio(studentProfileRequest.getBio());
        existingStudent.setFkGroupId(studentProfileRequest.getFkGroupId());

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.mapEntityToStudentProfile(updatedStudent);
    }
}
