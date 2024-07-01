package com.example.hilay_app.service.card;

import com.example.hilay_app.entity.Card;
import com.example.hilay_app.exception.CardNotFoundException;
import com.example.hilay_app.mapper.CardMapper;
import com.example.hilay_app.repository.CardRepository;
import com.example.hilay_app.response.read.CardReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardReadService {

    private final CardRepository cardRepository;


    private final CardMapper cardMapper;

    public CardReadResponse getCardById(Long id) {

        log.info("ActionLog.CardRead start");

        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(HttpStatus.NOT_FOUND.name(), "Card not found"));

        log.info("ActionLog.CardRead end");

        return cardMapper.cardToCardReadResponse(card);
    }

    public List<CardReadResponse> getCardsByTitle(String title) {
        List<Card> cards = cardRepository.findByTitle(title);
        return cards.stream()
                .map(cardMapper::cardToCardReadResponse)
                .collect(Collectors.toList());
    }

    public List<CardReadResponse> getCardsByContent(String content) {
        Optional<Card> cards = cardRepository.findByContent(content);
        return cards.stream()
                .map(cardMapper::cardToCardReadResponse)
                .collect(Collectors.toList());
    }

    public List<CardReadResponse> getCardsByFkImageId(Long fkImageId) {
        List<Card> cards = cardRepository.findByFkImageId(fkImageId);
        return cards.stream()
                .map(cardMapper::cardToCardReadResponse)
                .collect(Collectors.toList());
    }

    public List<CardReadResponse> getCardsByFkSubCategoryId(long fkSubCategoryId) {
        List<Card> cards = cardRepository.findByFkSubCategoryId(fkSubCategoryId);
        return cards.stream()
                .map(cardMapper::cardToCardReadResponse)
                .collect(Collectors.toList());
    }
}
