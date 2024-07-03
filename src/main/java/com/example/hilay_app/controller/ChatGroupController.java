package com.example.hilay_app.controller;
import com.example.hilay_app.request.create.ChatGroupCreateRequest;
import com.example.hilay_app.response.create.ChatGroupCreateResponse;
import com.example.hilay_app.service.chatGroup.ChatGroupCreateService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatGroups")
@RequiredArgsConstructor
public class ChatGroupController {

    private final ChatGroupCreateService chatGroupCreateService;


    @PostMapping
    public ResponseEntity<ChatGroupCreateResponse> createChatGroup(@RequestBody ChatGroupCreateRequest request) {
        ChatGroupCreateResponse response = chatGroupCreateService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
