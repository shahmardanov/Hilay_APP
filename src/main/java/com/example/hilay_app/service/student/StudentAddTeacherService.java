package com.example.hilay_app.service.student;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.exception.StudentNotFoundException;
import com.example.hilay_app.mapper.StudentMapper;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.create.StudentTeacherRequest;
import com.example.hilay_app.response.create.StudentTeacherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAddTeacherService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public StudentTeacherResponse addTeacher(StudentTeacherRequest studentTeacherRequest) {
        Student existingStudent = studentRepository.findByUsername(studentTeacherRequest.getUsername());
        if (existingStudent == null) {
            throw new StudentNotFoundException(HttpStatus.NOT_FOUND.name(), "User not found");
        }

        existingStudent.setFkTeacherId(studentTeacherRequest.getFkTeacherId());

        Student savedStudent = studentRepository.save(existingStudent);

        return studentMapper.entityMapToTeacherResponse(savedStudent);
    }}
