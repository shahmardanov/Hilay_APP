package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.AnswersCreateRequest;
import com.example.hilay_app.request.update.AnswersUpdateRequest;
import com.example.hilay_app.response.create.AnswersCreateResponse;
import com.example.hilay_app.response.read.AnswersReadResponse;
import com.example.hilay_app.response.update.AnswersUpdateResponse;
import com.example.hilay_app.service.answers.AnswerCreateService;
import com.example.hilay_app.service.answers.AnswerReadService;
import com.example.hilay_app.service.answers.AnswersDeleteService;
import com.example.hilay_app.service.answers.AnswersUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswersController {

    private final AnswerCreateService answerCreateService;
    private final AnswerReadService answerReadService;
    private final AnswersUpdateService answersUpdateService;
    private final AnswersDeleteService answersDeleteService;

    @PostMapping
    public ResponseEntity<AnswersCreateResponse> createAnswer(@RequestBody AnswersCreateRequest request) {
        AnswersCreateResponse response = answerCreateService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswersReadResponse> getAnswerById(@PathVariable Long id) {
        AnswersReadResponse response = answerReadService.read(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/question/{fkQuestionId}")
    public ResponseEntity<AnswersReadResponse> getAnswerByQuestionId(@PathVariable Long fkQuestionId) {
        AnswersReadResponse response = answerReadService.readFkQuestionId(fkQuestionId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswersUpdateResponse> updateAnswer(@PathVariable Long id, @RequestBody AnswersUpdateRequest request) {
        AnswersUpdateResponse response = answersUpdateService.updateAnswers(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answersDeleteService.deleteAnswers(id);
    }
}
