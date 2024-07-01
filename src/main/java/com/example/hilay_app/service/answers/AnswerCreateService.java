package com.example.hilay_app.service.answers;

import com.example.hilay_app.entity.Answers;
import com.example.hilay_app.mapper.AnswerMapper;
import com.example.hilay_app.repository.AnswersRepository;
import com.example.hilay_app.request.create.AnswersCreateRequest;
import com.example.hilay_app.response.create.AnswersCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerCreateService {

    private final AnswersRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswersCreateResponse create(AnswersCreateRequest request) {
        log.info("ActionLog.AnswerCreate service start");

        Answers answer = answerMapper.toEntity(request);
        Answers savedAnswer = answerRepository.save(answer);
        AnswersCreateResponse response = answerMapper.toCreateResponse(savedAnswer);

        log.info("ActionLog.AnswerCreate service end");
        return response;
    }
}
