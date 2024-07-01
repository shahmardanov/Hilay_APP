package com.example.hilay_app.service.student;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.exception.StudentNotFoundException;
import com.example.hilay_app.mapper.StudentMapper;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.update.StudentProfileUpdateRequest;
import com.example.hilay_app.response.update.StudentProfileUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileUpdateService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentProfileUpdateResponse update(Long id, StudentProfileUpdateRequest studentProfileUpdateRequest) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(HttpStatus.NOT_FOUND.name(), "Student  not found "));
        studentMapper.update(student, studentProfileUpdateRequest);
        student = studentRepository.save(student);

        return studentMapper.toUpdateResponse(student);
    }
}
