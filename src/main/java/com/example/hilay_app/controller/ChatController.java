package com.example.hilay_app.controller;

import com.example.hilay_app.entity.ChatMessage;
import com.example.hilay_app.repository.ChatMessageRepository;
import com.example.hilay_app.response.ChatMessageResponse;
import com.example.hilay_app.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/send")
    public void sendMessage(@RequestParam Long groupId,
                            @RequestParam String content,
                            @RequestParam ChatMessage.MessageType type) throws AccessDeniedException {
        chatService.sendMessage(groupId,content,type);
    }

    @GetMapping("/messages/{groupId}")
    public List<ChatMessageResponse> getMessagesByGroupId(@PathVariable Long groupId){
        return chatService.getMessageByGroupId(groupId);
    }
}
