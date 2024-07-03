package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.UserAnswersCreateRequest;
import com.example.hilay_app.response.create.UserAnswersCreateResponse;
import com.example.hilay_app.service.userAnswer.UserAnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-answers")
@RequiredArgsConstructor
public class UserAnswersController {

    private final UserAnswersService  userAnswersService;

    @PostMapping("/create")
    public ResponseEntity<UserAnswersCreateResponse> createUserAnswer(@RequestBody UserAnswersCreateRequest request) {
        UserAnswersCreateResponse response = userAnswersService.createUserAnswer(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkUserAnswer(@RequestBody UserAnswersCreateRequest request) {
        String result = userAnswersService.check(request);
        return ResponseEntity.ok(result);
    }
}
