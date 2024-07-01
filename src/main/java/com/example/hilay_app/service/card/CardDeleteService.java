package com.example.hilay_app.service.card;

import com.example.hilay_app.exception.CardNotFoundException;
import com.example.hilay_app.mapper.CardMapper;
import com.example.hilay_app.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardDeleteService {


    private final CardRepository cardRepository;


    private final CardMapper cardMapper;

    public ResponseEntity<?> deleteCard(Long id) {

        log.info("ActionLog.CardDelete start");


        cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(HttpStatus.NOT_FOUND.name(), "Card not found"));

        cardRepository.deleteById(id);


        log.info("ActionLog.CardDelete end");

        return ResponseEntity.ok("successfully");


    }
}
