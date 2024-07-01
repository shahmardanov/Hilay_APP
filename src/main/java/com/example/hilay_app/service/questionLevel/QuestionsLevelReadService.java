package com.example.hilay_app.service.questionLevel;

import com.example.hilay_app.entity.QuestionsLevel;
import com.example.hilay_app.exception.QuestionLevelNotFoundException;
import com.example.hilay_app.mapper.QuestionsLevelMapper;
import com.example.hilay_app.repository.QuestionsLevelRepository;
import com.example.hilay_app.response.read.QuestionsLevelReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionsLevelReadService {
    private final QuestionsLevelMapper questionsLevelMapper;
    private final QuestionsLevelRepository questionsLevelRepository;

    public QuestionsLevelReadResponse read(Long id){
        QuestionsLevel questionsLevel=questionsLevelRepository.findById(id).orElseThrow(()-> new QuestionLevelNotFoundException(HttpStatus.NOT_FOUND.name(),"Level of question not found"));
        return questionsLevelMapper.toLevelReadResponse(questionsLevel);
    }
}
