package com.example.hilay_app.service.question;

import com.example.hilay_app.entity.Questions;
import com.example.hilay_app.exception.QuestionNotFoundException;
import com.example.hilay_app.mapper.QuestionsMapper;
import com.example.hilay_app.repository.QuestionsRepository;
import com.example.hilay_app.request.update.QuestionsUpdateRequest;
import com.example.hilay_app.response.update.QuestionsUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionsUpdateService {

    private final QuestionsMapper questionsMapper;
    private final QuestionsRepository questionsRepository;


    public QuestionsUpdateResponse update(Long id, QuestionsUpdateRequest questionsUpdateRequest) {
        log.info("ActionLog.updateQuestion start with id# " + id);

        Questions questions = questionsRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException(HttpStatus.NOT_FOUND.name(), "Question id not found "));
        questionsMapper.mapForUpdate(questions, questionsUpdateRequest);
        questions = questionsRepository.save(questions);

        log.info("ActionLog.updateQuestion end");
        return questionsMapper.toUpdateResponse(questions);
    }
}
