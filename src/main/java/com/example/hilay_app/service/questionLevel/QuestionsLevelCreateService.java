package com.example.hilay_app.service.questionLevel;

import com.example.hilay_app.entity.QuestionsLevel;
import com.example.hilay_app.mapper.QuestionsLevelMapper;
import com.example.hilay_app.repository.QuestionsLevelRepository;
import com.example.hilay_app.request.create.QuestionsLevelCreateRequest;
import com.example.hilay_app.response.create.QuestionsLevelCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionsLevelCreateService {


    private final QuestionsLevelRepository questionsLevelRepository;

    private final QuestionsLevelMapper questionsLevelMapper;

    public QuestionsLevelCreateResponse createQuestionLevel(QuestionsLevelCreateRequest questionsLevelCreateRequest) {

        log.info("ActionLog.createQuestionLevel start");

        QuestionsLevel questionsLevel = questionsLevelMapper.toEntity(questionsLevelCreateRequest);
        QuestionsLevel savedQuestionsLevel = questionsLevelRepository.save(questionsLevel);

        log.info("ActionLog.createQuestionLevel end");
        return questionsLevelMapper.toResponse(savedQuestionsLevel);
    }
}
