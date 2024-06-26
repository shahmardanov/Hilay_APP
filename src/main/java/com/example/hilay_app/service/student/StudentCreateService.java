package com.example.hilay_app.service.student;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.exception.StudentExistsException;
import com.example.hilay_app.mapper.StudentMapper;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.request.login.StudentLoginRequest;
import com.example.hilay_app.response.create.StudentCreateResponse;
import com.example.hilay_app.response.login.StudentLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

          if (existsByUsername(registerRequest.getUsername())) {
               throw new StudentExistsException(HttpStatus.CONFLICT.name(), "User already exists");
          }
          Student student = studentMapper.mapCreateRequestToStudent(registerRequest);
          student.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

          Student savedStudent = studentRepository.save(student);
          return studentMapper.mapStudentToCreateResponse(savedStudent);
     }

}
