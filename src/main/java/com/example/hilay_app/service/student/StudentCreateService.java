package com.example.hilay_app.service.student;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.exception.StudentExistsException;
import com.example.hilay_app.exception.ValidationException;
import com.example.hilay_app.mapper.StudentMapper;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.response.create.StudentCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentCreateService {
     private final StudentRepository studentRepository;
     private final StudentMapper studentMapper;

     private final PasswordEncoder passwordEncoder;



     public boolean existsByUsername(String username) {
          return studentRepository.findByUsername(username) != null;
     }



     public StudentCreateResponse register(StudentCreateRequest registerRequest) {

          if (registerRequest.getUsername() == null || registerRequest.getUsername().isEmpty()) {
               throw new ValidationException(HttpStatus.BAD_REQUEST.name(), "Username cannot be empty");
          }

          if (registerRequest.getPassword() == null || registerRequest.getPassword().isEmpty()) {
               throw new ValidationException(HttpStatus.BAD_REQUEST.name(), "Password cannot be empty");
          }

          if (existsByUsername(registerRequest.getUsername())) {
               throw new StudentExistsException(HttpStatus.CONFLICT.name(), "User already exists");
          }
          Student student = studentMapper.mapCreateRequestToStudent(registerRequest);
          student.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

          Student savedStudent = studentRepository.save(student);
          return studentMapper.mapStudentToCreateResponse(savedStudent);
     }

}
