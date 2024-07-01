package com.example.hilay_app.service.teacher;

import com.example.hilay_app.entity.Teacher;
import com.example.hilay_app.exception.TeacherNotFoundException;
import com.example.hilay_app.mapper.TeacherMapper;
import com.example.hilay_app.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherDeleteService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public ResponseEntity<?> delete(Long id) {
        log.info("ActionLog.TeacherDelete service start");

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(HttpStatus.NOT_FOUND.name(), "Teacher not found"));

        teacherRepository.delete(teacher);

        log.info("ActionLog.TeacherDelete service end");
        return ResponseEntity.ok("successfully");

    }
}
