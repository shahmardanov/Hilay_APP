package com.example.hilay_app.service.card;

import com.example.hilay_app.entity.Card;
import com.example.hilay_app.exception.CardConflictException;
import com.example.hilay_app.mapper.CardMapper;
import com.example.hilay_app.repository.CardRepository;
import com.example.hilay_app.request.create.CardCreateRequest;
import com.example.hilay_app.response.create.CardCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardCreateService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    public CardCreateResponse create(CardCreateRequest cardCreateRequest){

        if(cardRepository.findByContent(cardCreateRequest.getContent()).isPresent()){
            throw new CardConflictException(HttpStatus.CONFLICT.name(), "Content is exists");
        }
        log.info("ActionLog.cardCreate start");

        Card card=cardMapper.cardCreateRequestToCard(cardCreateRequest);
        Card cardSave=cardRepository.save(card);
        CardCreateResponse cardResponse=cardMapper.cardToCardCreateResponse(cardSave);

        log.info("ActionLog.cardCreate end");

        return cardResponse;
    }
}
