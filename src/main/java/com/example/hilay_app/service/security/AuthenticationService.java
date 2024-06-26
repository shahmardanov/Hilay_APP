package com.example.hilay_app.service.security;

import com.example.hilay_app.entity.Student;

import com.example.hilay_app.exception.InvalidPasswordException;
import com.example.hilay_app.exception.InvalidUsernameException;
import com.example.hilay_app.exception.StudentNotFoundException;
import com.example.hilay_app.repository.StudentRepository;
import com.example.hilay_app.request.login.StudentLoginRequest;
import com.example.hilay_app.response.login.StudentLoginResponse;
import com.example.hilay_app.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentMapper studentMapper;

    public StudentLoginResponse authenticateAndGetLoginResponse(StudentLoginRequest loginRequest) {
        Authentication authentication = authenticate(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Student student = studentRepository.findByUsername(loginRequest.getUsername());
        if (student == null) {
            throw new StudentNotFoundException(HttpStatus.NOT_FOUND.name(), "Student not found");
        }
        return studentMapper.mapStudentToLoginResponse(student);
    }

    public Authentication authenticate(StudentLoginRequest loginRequest) {

        Student student = studentRepository.findByUsername(loginRequest.getUsername());
        if (student == null) {
            throw new InvalidUsernameException(HttpStatus.UNAUTHORIZED.name(),"Invalid username");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
            throw new InvalidPasswordException(HttpStatus.UNAUTHORIZED.name(),"Invalid password");
        }

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
    }
    }

