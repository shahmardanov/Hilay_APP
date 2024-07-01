package com.example.hilay_app.service.teacher;

import com.example.hilay_app.entity.Teacher;
import com.example.hilay_app.exception.TeacherNotFoundException;
import com.example.hilay_app.mapper.TeacherMapper;
import com.example.hilay_app.repository.TeacherRepository;
import com.example.hilay_app.response.read.TeacherReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherReadService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    public TeacherReadResponse read(Long id) {
        log.info("ActionLog.TeacherRead service start");

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(HttpStatus.NOT_FOUND.name(), "Teacher not found"));

        TeacherReadResponse response = teacherMapper.toReadResponse(teacher);

        log.info("ActionLog.TeacherRead service end");
        return response;
    }

    public List<TeacherReadResponse> readAll() {
        log.info("ActionLog.TeacherReadAll service start");

        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) {
            throw new TeacherNotFoundException(HttpStatus.NOT_FOUND.name(), "No teachers found");
        }

        List<TeacherReadResponse> responses = teachers.stream()
                .map(teacherMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.TeacherReadAll service end");
        return responses;
    }

}
