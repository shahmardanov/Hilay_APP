package com.example.hilay_app.service.answers;

import com.example.hilay_app.exception.AnswerNotFoundException;
import com.example.hilay_app.repository.AnswersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswersDeleteService {

    private final AnswersRepository answerRepository;

    public void deleteAnswers(Long id) {
        log.info("ActionLog.AnswersDelete service start");

        answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(HttpStatus.NOT_FOUND.name(), "Answers not found"));

        answerRepository.deleteById(id);

        log.info("ActionLog.AnswersDelete service end");
        ResponseEntity.ok("successfully");
    }
}
