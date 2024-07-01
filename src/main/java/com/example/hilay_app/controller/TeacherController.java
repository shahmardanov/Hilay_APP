package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.TeacherCreateRequest;
import com.example.hilay_app.request.update.TeacherUpdateRequest;
import com.example.hilay_app.response.create.TeacherCreateResponse;
import com.example.hilay_app.response.read.TeacherReadResponse;
import com.example.hilay_app.response.update.TeacherUpdateResponse;
import com.example.hilay_app.service.teacher.TeacherCreateService;
import com.example.hilay_app.service.teacher.TeacherDeleteService;
import com.example.hilay_app.service.teacher.TeacherReadService;
import com.example.hilay_app.service.teacher.TeacherUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherCreateService teacherCreateService;
    private final TeacherReadService teacherReadService;
    private final TeacherUpdateService teacherUpdateService;
    private final TeacherDeleteService teacherDeleteService;

    @PostMapping
    public ResponseEntity<TeacherCreateResponse> create(@RequestBody TeacherCreateRequest request) {
        TeacherCreateResponse response = teacherCreateService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherReadResponse> read(@PathVariable Long id) {
        TeacherReadResponse response = teacherReadService.read(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<TeacherReadResponse>> getAllTeachers() {
        List<TeacherReadResponse> teachers = teacherReadService.readAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeacherUpdateResponse> update(@PathVariable Long id, @RequestBody TeacherUpdateRequest request) {
        TeacherUpdateResponse response = teacherUpdateService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return teacherDeleteService.delete(id);

    }
}
