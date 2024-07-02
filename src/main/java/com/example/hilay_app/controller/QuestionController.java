package com.example.hilay_app.controller;

import com.example.hilay_app.request.update.QuestionsUpdateRequest;
import com.example.hilay_app.response.read.QuestionsReadResponse;
import com.example.hilay_app.response.update.QuestionsUpdateResponse;
import com.example.hilay_app.service.question.QuestionCreateService;
import com.example.hilay_app.service.question.QuestionsDeleteService;
import com.example.hilay_app.service.question.QuestionsReadService;
import com.example.hilay_app.service.question.QuestionsUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionCreateService questionCreateService;
    private final QuestionsUpdateService questionsUpdateService;
    private final QuestionsDeleteService questionsDeleteService;
    private final QuestionsReadService questionsReadService;
    @PostMapping("/create")
    public String createQuestion(@RequestParam String questionText,
                                 @RequestParam Long fkLevelId,
                                 @RequestParam Long fkCardId,
                                 @RequestParam (value = "file", required = false) MultipartFile file) throws IOException{

        return questionCreateService.createQuestion(questionText,fkLevelId,fkCardId,file);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionsReadResponse> getQuestionById(@PathVariable("questionId") long questionId) {
        QuestionsReadResponse response = questionsReadService.getQuestionById(questionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<QuestionsReadResponse>> getAllQuestions() {
        List<QuestionsReadResponse> responses = questionsReadService.readAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/fkImageId/{fkImageId}")
    public ResponseEntity<List<QuestionsReadResponse>> getQuestionsByFkImageId(@PathVariable Long fkImageId) {
        List<QuestionsReadResponse> responses = questionsReadService.readByFkImageId(fkImageId);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/fkLevelId/{fkLevelId}")
    public ResponseEntity<List<QuestionsReadResponse>> getQuestionsByFkLevelId(@PathVariable long fkLevelId) {
        List<QuestionsReadResponse> responses = questionsReadService.readByFkLevelId(fkLevelId);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/fkCardId/{fkCardId}")
    public ResponseEntity<List<QuestionsReadResponse>> getQuestionsByFkCardId(@PathVariable long fkCardId) {
        List<QuestionsReadResponse> responses = questionsReadService.readByFkCardId(fkCardId);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<QuestionsUpdateResponse> updateQuestion(@PathVariable("questionId") long questionId,
                                                                  @RequestBody QuestionsUpdateRequest request) {
        QuestionsUpdateResponse response=questionsUpdateService.update(questionId,request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") long questionId) {
        return questionsDeleteService.delete(questionId);
    }



}
