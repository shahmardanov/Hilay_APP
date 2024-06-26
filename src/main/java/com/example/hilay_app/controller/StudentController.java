package com.example.hilay_app.controller;


import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.request.login.StudentLoginRequest;
import com.example.hilay_app.response.create.StudentCreateResponse;
import com.example.hilay_app.response.login.StudentLoginResponse;
import com.example.hilay_app.service.student.StudentCreateService;
import com.example.hilay_app.service.student.StudentLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class StudentController {

    private final StudentCreateService studentCreateService;
    private final StudentLoginService studentLoginService;

    @PostMapping("/register")
    public ResponseEntity<StudentCreateResponse> register(@RequestBody StudentCreateRequest registerRequest) {
        StudentCreateResponse response = studentCreateService.register(registerRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<StudentLoginResponse> login(@RequestBody StudentLoginRequest loginRequest) {
        StudentLoginResponse response = studentLoginService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
