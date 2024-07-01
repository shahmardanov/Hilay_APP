package com.example.hilay_app.service.teacher;

import com.example.hilay_app.entity.Teacher;
import com.example.hilay_app.mapper.TeacherMapper;
import com.example.hilay_app.repository.TeacherRepository;
import com.example.hilay_app.request.create.TeacherCreateRequest;
import com.example.hilay_app.response.create.TeacherCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherCreateService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherCreateResponse create(TeacherCreateRequest request) {
        log.info("ActionLog.TeacherCreate service start");

        Teacher teacher = teacherMapper.toTeacher(request);
        Teacher savedTeacher = teacherRepository.save(teacher);
        TeacherCreateResponse response = teacherMapper.toCreateResponse(savedTeacher);

        log.info("ActionLog.TeacherCreate service end");
        return response;
    }
}
