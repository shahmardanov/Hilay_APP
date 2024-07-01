package com.example.hilay_app.service.questionLevel;

import com.example.hilay_app.entity.QuestionsLevel;
import com.example.hilay_app.exception.QuestionLevelNotFoundException;
import com.example.hilay_app.repository.QuestionsLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionsLevelDeleteService {

    private final QuestionsLevelRepository questionsLevelRepository;


    public ResponseEntity<?> delete(Long id){
        QuestionsLevel questionsLevel=questionsLevelRepository.findById(id).orElseThrow(()->new QuestionLevelNotFoundException(HttpStatus.NOT_FOUND.name(),"Level of question not found"));
        questionsLevelRepository.delete(questionsLevel);
        return ResponseEntity.ok("successfully deleted");

    }
}
