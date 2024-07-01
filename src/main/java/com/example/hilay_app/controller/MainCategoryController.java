package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.MainCategoryCreateRequest;
import com.example.hilay_app.request.update.MainCategoryUpdateRequest;
import com.example.hilay_app.response.create.MainCategoryCreateResponse;
import com.example.hilay_app.response.read.MainCategoryReadResponse;
import com.example.hilay_app.response.update.MainCategoryUpdateResponse;
import com.example.hilay_app.service.mainCategory.MainCategoryCreateService;
import com.example.hilay_app.service.mainCategory.MainCategoryDeleteService;
import com.example.hilay_app.service.mainCategory.MainCategoryReadService;
import com.example.hilay_app.service.mainCategory.MainCategoryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainCategories")
@RequiredArgsConstructor
public class MainCategoryController {

    private final MainCategoryCreateService mainCategoryCreateService;
    private final MainCategoryReadService mainCategoryReadService;
    private final MainCategoryUpdateService mainCategoryUpdateService;
    private final MainCategoryDeleteService mainCategoryDeleteService;

    @PostMapping
    public ResponseEntity<MainCategoryCreateResponse> createMainCategory(@RequestBody MainCategoryCreateRequest request) {
        MainCategoryCreateResponse response = mainCategoryCreateService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainCategoryReadResponse> getMainCategoryById(@PathVariable Long id) {
        MainCategoryReadResponse response = mainCategoryReadService.read(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MainCategoryReadResponse>> getAllMainCategories() {
        List<MainCategoryReadResponse> responses = mainCategoryReadService.readAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MainCategoryUpdateResponse> updateMainCategory(@PathVariable Long id, @RequestBody MainCategoryUpdateRequest request) {
        MainCategoryUpdateResponse response = mainCategoryUpdateService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMainCategory(@PathVariable Long id) {
        return  mainCategoryDeleteService.delete(id);

    }
}
