package com.example.hilay_app.service.question;

import com.example.hilay_app.exception.QuestionNotFoundException;
import com.example.hilay_app.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionsDeleteService {
   private final QuestionsRepository questionsRepository;

    public  ResponseEntity<?> delete(Long id){
        log.info("ActionLog.deleteQuestion start with id# " + id);

        if (!questionsRepository.existsById(id)) {
            throw new QuestionNotFoundException(HttpStatus.NOT_FOUND.name(), "Question not found");
        }
         questionsRepository.deleteById(id);

        log.info("ActionLog.deleteQuestion end ");
        return ResponseEntity.ok("successfully");
    }
}
