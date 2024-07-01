package com.example.hilay_app.service.subCategory;

import com.example.hilay_app.entity.SubCategory;
import com.example.hilay_app.exception.SubCategoryNotFoundException;
import com.example.hilay_app.mapper.SubCategoryMapper;
import com.example.hilay_app.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryDeleteService {

    private final SubCategoryRepository subCategoryRepository;

    private final SubCategoryMapper subCategoryMapper;

    public ResponseEntity<?> delete(long id) {

        log.info("ActionLog.SubCategoryDelete start");

        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new SubCategoryNotFoundException(HttpStatus.NOT_FOUND.name(),"SubCategory not found"));
        subCategoryRepository.delete(subCategory);

        log.info("ActionLog.SubCategoryDelete end");

        return ResponseEntity.ok("successfully");

    }
}
