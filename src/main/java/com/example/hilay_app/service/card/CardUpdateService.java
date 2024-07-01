package com.example.hilay_app.service.card;

import com.example.hilay_app.entity.Card;
import com.example.hilay_app.exception.CardNotFoundException;
import com.example.hilay_app.mapper.CardMapper;
import com.example.hilay_app.repository.CardRepository;
import com.example.hilay_app.request.update.CardUpdateRequest;
import com.example.hilay_app.response.update.CardUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardUpdateService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    public CardUpdateResponse updateCard(Long id, CardUpdateRequest request) {

        log.info("ActionLog.CardUpdate start");


        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(HttpStatus.NOT_FOUND.name(), "Card not found"));
        cardMapper.updateCardFromRequest(card, request);
        Card updatedCard = cardRepository.save(card);

        log.info("ActionLog.CardUpdate end");

        return cardMapper.cardToCardUpdateResponse(updatedCard);
    }
}
