package com.example.hilay_app.service.chatMessage;

import com.example.hilay_app.entity.ChatMessage;
import com.example.hilay_app.repository.ChatGroupRepository;
import com.example.hilay_app.repository.ChatMessageRepository;
import com.example.hilay_app.response.ChatMessageResponse;
import com.example.hilay_app.util.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatGroupRepository chatGroupRepository;

    @Transactional
    public void sendMessage(Long groupId, String content, ChatMessage.MessageType type) throws AccessDeniedException {

        String currentUsername = SecurityUtils.getUsername();

        // check group
        if (!chatGroupRepository.existsById(groupId)) {
            throw new IllegalArgumentException("Group not found");
        }

        // create message and save
        ChatMessage message = new ChatMessage();
        message.setGroupId(groupId);
        message.setSender(currentUsername);
        message.setContent(content);
        message.setType(type);
        message.setTimestamp(LocalDateTime.now());

        chatMessageRepository.save(message);
    }

    public List<ChatMessageResponse> getMessageByGroupId(Long groupId) {

        if (!chatGroupRepository.existsById(groupId)) {
            throw new IllegalArgumentException("Group not found");
        }

        List<ChatMessage> chatMessages = chatMessageRepository.findByGroupId(groupId);
        List<ChatMessageResponse> chatMessageResponses = new ArrayList<>();

        for (ChatMessage chatMessage : chatMessages) {
            ChatMessageResponse response = new ChatMessageResponse(
                    chatMessage.getId(),
                    chatMessage.getType(),
                    chatMessage.getContent(),
                    chatMessage.getSender(),
                    chatMessage.getTimestamp()
            );
            chatMessageResponses.add(response);
        }

        return chatMessageResponses;
    }
}
