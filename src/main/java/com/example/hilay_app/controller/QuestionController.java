package com.example.hilay_app.controller;

import com.example.hilay_app.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    @PostMapping("/create")
    public String createQuestion(@RequestParam String questionText,
                                 @RequestParam Long fkLevelId,
                                 @RequestParam Long fkCardId,
                                 @RequestParam (value = "file", required = false) MultipartFile file) throws IOException{

        return questionService.createQuestion(questionText,fkLevelId,fkCardId,file);
    }
}
