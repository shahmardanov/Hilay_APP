package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.QuestionsLevelCreateRequest;
import com.example.hilay_app.request.update.QuestionsLevelUpdateRequest;
import com.example.hilay_app.response.create.QuestionsLevelCreateResponse;
import com.example.hilay_app.response.read.QuestionsLevelReadResponse;
import com.example.hilay_app.response.update.QuestionsLevelUpdateResponse;
import com.example.hilay_app.service.questionLevel.QuestionsLevelCreateService;
import com.example.hilay_app.service.questionLevel.QuestionsLevelDeleteService;
import com.example.hilay_app.service.questionLevel.QuestionsLevelReadService;
import com.example.hilay_app.service.questionLevel.QuestionsLevelUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions-level")
@RequiredArgsConstructor
@Slf4j
public class QuestionsLevelController {

    private final QuestionsLevelCreateService questionsLevelCreateService;
    private final QuestionsLevelReadService questionsLevelReadService;
    private final QuestionsLevelUpdateService questionsLevelUpdateService;
    private final QuestionsLevelDeleteService questionsLevelDeleteService;

    @PostMapping
    public ResponseEntity<QuestionsLevelCreateResponse> createQuestionLevel(@RequestBody QuestionsLevelCreateRequest request) {
        QuestionsLevelCreateResponse response = questionsLevelCreateService.createQuestionLevel(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionsLevelReadResponse> readQuestionLevel(@PathVariable Long id) {
        QuestionsLevelReadResponse response = questionsLevelReadService.read(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionsLevelUpdateResponse> updateQuestionLevel(@PathVariable Long id, @RequestBody QuestionsLevelUpdateRequest request) {
       QuestionsLevelUpdateResponse response = questionsLevelUpdateService.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionLevel(@PathVariable Long id) {
        return questionsLevelDeleteService.delete(id);

    }
}
