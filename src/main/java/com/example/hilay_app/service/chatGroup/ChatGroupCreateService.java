package com.example.hilay_app.service.chatGroup;

import com.example.hilay_app.entity.ChatGroup;
import com.example.hilay_app.exception.ChatGroupExistsException;
import com.example.hilay_app.mapper.ChatGroupMapper;
import com.example.hilay_app.repository.ChatGroupRepository;

import com.example.hilay_app.request.create.ChatGroupCreateRequest;
import com.example.hilay_app.response.create.ChatGroupCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatGroupCreateService {

    private final ChatGroupRepository chatGroupRepository;
    private final ChatGroupMapper chatGroupMapper;

    public ChatGroupCreateResponse create(ChatGroupCreateRequest request) {
        log.info("ActionLog.ChatGroupCreate service start");

        if(chatGroupRepository.findByName(request.getName())!=null){
            throw new ChatGroupExistsException(HttpStatus.CONFLICT.name(), "Group is exists");
        }

        ChatGroup chatGroup = chatGroupMapper.toEntity(request);
        ChatGroup savedChatGroup = chatGroupRepository.save(chatGroup);
        ChatGroupCreateResponse response = chatGroupMapper.toCreateResponse(savedChatGroup);

        log.info("ActionLog.ChatGroupCreate service end");
        return response;
    }




}
