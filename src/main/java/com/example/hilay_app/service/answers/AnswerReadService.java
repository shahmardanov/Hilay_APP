package com.example.hilay_app.service.answers;

import com.example.hilay_app.entity.Answers;
import com.example.hilay_app.exception.AnswerNotFoundException;
import com.example.hilay_app.mapper.AnswerMapper;
import com.example.hilay_app.repository.AnswersRepository;
import com.example.hilay_app.response.read.AnswersReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerReadService {

    private final AnswersRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswersReadResponse read(Long id) {
        log.info("ActionLog.AnswerRead service start");

        Answers answer = answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(HttpStatus.NOT_FOUND.name(), "Answer not found"));

        AnswersReadResponse response = answerMapper.toReadResponse(answer);

        log.info("ActionLog.AnswerRead service end");
        return response;
    }

    public AnswersReadResponse readFkQuestionId( Long fkQuestionId) {
        log.info("ActionLog.AnswerRead service start");

        Answers answer = answerRepository.findByFkQuestionId(fkQuestionId);
        AnswersReadResponse response = answerMapper.toReadResponse(answer);

        log.info("ActionLog.AnswerRead service end");
        return response;
    }
}
