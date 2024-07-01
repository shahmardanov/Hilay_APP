package com.example.hilay_app.service.teacher;

import com.example.hilay_app.entity.Teacher;
import com.example.hilay_app.exception.TeacherNotFoundException;
import com.example.hilay_app.mapper.TeacherMapper;
import com.example.hilay_app.repository.TeacherRepository;
import com.example.hilay_app.request.update.TeacherUpdateRequest;
import com.example.hilay_app.response.update.TeacherUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherUpdateService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherUpdateResponse update(Long id, TeacherUpdateRequest request) {
        log.info("ActionLog.TeacherUpdate service start");

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(HttpStatus.NOT_FOUND.name(), "Teacher not found"));

        teacherMapper.updateTeacherFromRequest(request, teacher);
        Teacher updatedTeacher = teacherRepository.save(teacher);

        TeacherUpdateResponse response = teacherMapper.toUpdateResponse(updatedTeacher);

        log.info("ActionLog.TeacherUpdate service end");
        return response;
    }
}
