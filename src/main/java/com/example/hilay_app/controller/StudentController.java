package com.example.hilay_app.controller;


import com.example.hilay_app.request.StudentProfileRequest;
import com.example.hilay_app.request.create.StudentCreateRequest;
import com.example.hilay_app.request.create.StudentTeacherRequest;
import com.example.hilay_app.request.login.StudentLoginRequest;
import com.example.hilay_app.request.update.StudentProfileUpdateRequest;
import com.example.hilay_app.response.StudentProfileResponse;
import com.example.hilay_app.response.create.StudentCreateResponse;
import com.example.hilay_app.response.create.StudentTeacherResponse;
import com.example.hilay_app.response.login.StudentLoginResponse;
import com.example.hilay_app.response.update.StudentProfileUpdateResponse;
import com.example.hilay_app.service.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentCreateService studentCreateService;
    private final StudentLoginService studentLoginService;
    private final StudentProfileUpdateService  studentProfileUpdateService;
    private final StudentProfileService studentProfileService;
    private final StudentAddTeacherService studentAddTeacherService;

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



    @PostMapping("/profile")
    public ResponseEntity<StudentProfileResponse> profile(@RequestBody StudentProfileRequest studentProfileRequest) {
        StudentProfileResponse response = studentProfileService.profile(studentProfileRequest);
        return ResponseEntity.ok(response);
    }



    @PutMapping("/{id}")
    public ResponseEntity<StudentProfileUpdateResponse> updateProfile(@PathVariable Long id, @RequestBody StudentProfileUpdateRequest request) {
        var response=studentProfileUpdateService.update(id,request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<StudentTeacherResponse> addTeacher(@RequestBody StudentTeacherRequest request) {
        StudentTeacherResponse response = studentAddTeacherService.addTeacher(request);
        return ResponseEntity.ok(response);
    }
}
