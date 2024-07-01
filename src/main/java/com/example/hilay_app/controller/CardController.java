package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.CardCreateRequest;
import com.example.hilay_app.request.update.CardUpdateRequest;
import com.example.hilay_app.response.create.CardCreateResponse;
import com.example.hilay_app.response.read.CardReadResponse;
import com.example.hilay_app.response.update.CardUpdateResponse;
import com.example.hilay_app.service.card.CardCreateService;
import com.example.hilay_app.service.card.CardDeleteService;
import com.example.hilay_app.service.card.CardReadService;
import com.example.hilay_app.service.card.CardUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardDeleteService cardDeleteService;

    private final CardReadService cardReadService;

    private final CardUpdateService cardUpdateService;
    private final CardCreateService cardCreateService;

    @PostMapping
    public ResponseEntity<CardCreateResponse> createCard(@RequestBody CardCreateRequest cardCreateRequest) {
        CardCreateResponse response = cardCreateService.create(cardCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable("id") Long id) {
        return cardDeleteService.deleteCard(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardReadResponse> getCardById(@PathVariable("id") Long id) {
        CardReadResponse response = cardReadService.getCardById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardUpdateResponse> updateCard(@PathVariable("id") Long id, @RequestBody CardUpdateRequest request) {
        CardUpdateResponse response = cardUpdateService.updateCard(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<CardReadResponse>> getCardsByTitle(@PathVariable("title") String title) {
        List<CardReadResponse> response = cardReadService.getCardsByTitle(title);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/content/{content}")
    public ResponseEntity<List<CardReadResponse>> getCardsByContent(@PathVariable("content") String content) {
        List<CardReadResponse> response = cardReadService.getCardsByContent(content);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fkImageId/{fkImageId}")
    public ResponseEntity<List<CardReadResponse>> getCardsByFkImageId(@PathVariable("fkImageId") Long fkImageId) {
        List<CardReadResponse> response = cardReadService.getCardsByFkImageId(fkImageId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fkSubCategoryId/{fkSubCategoryId}")
    public ResponseEntity<List<CardReadResponse>> getCardsByFkSubCategoryId(@PathVariable("fkSubCategoryId") long fkSubCategoryId) {
        List<CardReadResponse> response = cardReadService.getCardsByFkSubCategoryId(fkSubCategoryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
