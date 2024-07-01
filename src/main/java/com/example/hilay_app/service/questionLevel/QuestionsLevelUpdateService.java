package com.example.hilay_app.service.questionLevel;

import com.example.hilay_app.entity.QuestionsLevel;
import com.example.hilay_app.exception.QuestionLevelNotFoundException;
import com.example.hilay_app.mapper.QuestionsLevelMapper;
import com.example.hilay_app.repository.QuestionsLevelRepository;
import com.example.hilay_app.request.update.QuestionsLevelUpdateRequest;
import com.example.hilay_app.response.update.QuestionsLevelUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionsLevelUpdateService {


    private final QuestionsLevelRepository questionsLevelRepository;
    private final QuestionsLevelMapper questionsLevelMapper;

    public QuestionsLevelUpdateResponse update(Long id, QuestionsLevelUpdateRequest request) {
        log.info("ActionLog.QuestionsLevelUpdate service start");

        QuestionsLevel questionsLevel = questionsLevelRepository.findById(id)
                .orElseThrow(() -> new QuestionLevelNotFoundException(HttpStatus.NOT_FOUND.name(), "QuestionsLevel not found"));

        questionsLevelMapper.questionsLevelUpdateFromRequest(request, questionsLevel);
        QuestionsLevel updatedQuestionsLevel = questionsLevelRepository.save(questionsLevel);
        QuestionsLevelUpdateResponse response = questionsLevelMapper.toLevelUpdateResponse(updatedQuestionsLevel);

        log.info("ActionLog.QuestionsLevelUpdate service end");
        return response;
    }
}
