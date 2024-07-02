package com.example.hilay_app.service.question;

import com.example.hilay_app.entity.Questions;
import com.example.hilay_app.exception.QuestionNotFoundException;
import com.example.hilay_app.mapper.QuestionsMapper;
import com.example.hilay_app.repository.QuestionsRepository;
import com.example.hilay_app.response.read.QuestionsReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionsReadService {


    private final QuestionsRepository questionsRepository;


    private final QuestionsMapper questionsMapper;

    public QuestionsReadResponse getQuestionById(long questionId) {
        Questions question = questionsRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException(HttpStatus.NOT_FOUND.name(), "Question not found"));
        return questionsMapper.toReadResponse(question);
    }


    public List<QuestionsReadResponse> readAll() {
        log.info("ActionLog.QuestionsReadAll service start");

        List<Questions> questions = questionsRepository.findAll();
        List<QuestionsReadResponse> responses = questions.stream()
                .map(questionsMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.QuestionsReadAll service end");
        return responses;
    }

    public List<QuestionsReadResponse> readByFkImageId(Long fkImageId) {
        log.info("ActionLog.QuestionsReadByFkImageId service start");

        List<Questions> questions = questionsRepository.findByFkImageId(fkImageId);
        List<QuestionsReadResponse> responses = questions.stream()
                .map(questionsMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.QuestionsReadByFkImageId service end");
        return responses;
    }

    public List<QuestionsReadResponse> readByFkLevelId(long fkLevelId) {
        log.info("ActionLog.QuestionsReadByFkLevelId service start");

        List<Questions> questions = questionsRepository.findByFkLevelId(fkLevelId);
        List<QuestionsReadResponse> responses = questions.stream()
                .map(questionsMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.QuestionsReadByFkLevelId service end");
        return responses;
    }

    public List<QuestionsReadResponse> readByFkCardId(long fkCardId) {
        log.info("ActionLog.QuestionsReadByFkCardId service start");

        List<Questions> questions = questionsRepository.findByFkCardId(fkCardId);
        List<QuestionsReadResponse> responses = questions.stream()
                .map(questionsMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.QuestionsReadByFkCardId service end");
        return responses;
    }

}
