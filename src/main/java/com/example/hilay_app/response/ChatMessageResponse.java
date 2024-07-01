package com.example.hilay_app.response;

import com.example.hilay_app.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageResponse {

    private Long id;
    private ChatMessage.MessageType type;
    private String content;
    private String sender;
    private LocalDateTime timestamp;

}
