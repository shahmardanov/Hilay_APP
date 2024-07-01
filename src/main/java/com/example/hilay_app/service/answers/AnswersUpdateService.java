package com.example.hilay_app.service.answers;

import com.example.hilay_app.entity.Answers;
import com.example.hilay_app.exception.AnswerNotFoundException;
import com.example.hilay_app.mapper.AnswerMapper;
import com.example.hilay_app.repository.AnswersRepository;
import com.example.hilay_app.request.update.AnswersUpdateRequest;
import com.example.hilay_app.response.update.AnswersUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswersUpdateService {

    private final AnswersRepository answerRepository;
    private final AnswerMapper answerMapper;



    public AnswersUpdateResponse updateAnswers(Long id, AnswersUpdateRequest request) {
        log.info("ActionLog.AnswersUpdate service start");

        Answers answers = answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(HttpStatus.NOT_FOUND.name(), "Answers not found"));

        answerMapper.updateFromRequest(answers, request);
        Answers updatedAnswers = answerRepository.save(answers);

        log.info("ActionLog.AnswersUpdate service end");

        return answerMapper.toUpdateResponse(updatedAnswers);
    }
}
