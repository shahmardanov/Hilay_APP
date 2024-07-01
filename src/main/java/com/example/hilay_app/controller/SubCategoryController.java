package com.example.hilay_app.controller;

import com.example.hilay_app.request.create.SubCategoryCreateRequest;
import com.example.hilay_app.request.update.SubCategoryUpdateRequest;
import com.example.hilay_app.response.create.SubCategoryCreateResponse;
import com.example.hilay_app.response.read.SubCategoryReadResponse;
import com.example.hilay_app.response.update.SubCategoryUpdateResponse;
import com.example.hilay_app.service.subCategory.SubCategoryCreateService;
import com.example.hilay_app.service.subCategory.SubCategoryDeleteService;
import com.example.hilay_app.service.subCategory.SubCategoryReadService;
import com.example.hilay_app.service.subCategory.SubCategoryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryCreateService subCategoryCreateService;
    private final SubCategoryReadService subCategoryReadService;
    private final SubCategoryUpdateService subCategoryUpdateService;
    private final SubCategoryDeleteService subCategoryDeleteService;

    @PostMapping
    public ResponseEntity<SubCategoryCreateResponse> createSubCategory(@RequestBody SubCategoryCreateRequest request) {
        SubCategoryCreateResponse response = subCategoryCreateService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubCategoryReadResponse>> getAllSubCategories() {
        List<SubCategoryReadResponse> responses = subCategoryReadService.getAllSubCategories();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryReadResponse> getSubCategoryById(@PathVariable long id) {
        SubCategoryReadResponse response = subCategoryReadService.getSubCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/name/{subCategoryName}")
    public ResponseEntity<List<SubCategoryReadResponse>> getSubCategoriesByName(@PathVariable String subCategoryName) {
        List<SubCategoryReadResponse> responses = subCategoryReadService.readBySubCategoryName(subCategoryName);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/fkMainCategoryId/{fkMainCategoryId}")
    public ResponseEntity<List<SubCategoryReadResponse>> getSubCategoriesByFkMainCategoryId(@PathVariable long fkMainCategoryId) {
        List<SubCategoryReadResponse> responses = subCategoryReadService.readByFkMainCategoryId(fkMainCategoryId);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryUpdateResponse> updateSubCategory(@PathVariable long id, @RequestBody SubCategoryUpdateRequest request) {
        SubCategoryUpdateResponse response = subCategoryUpdateService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubCategory(@PathVariable long id) {
       return subCategoryDeleteService.delete(id);
    }
}
