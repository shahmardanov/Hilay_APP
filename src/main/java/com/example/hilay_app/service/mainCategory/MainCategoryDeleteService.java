package com.example.hilay_app.service.mainCategory;

import com.example.hilay_app.exception.MainCategoryNotFoundException;
import com.example.hilay_app.repository.MainCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainCategoryDeleteService {

    private final MainCategoryRepository mainCategoryRepository;

    public ResponseEntity<?> delete(Long id) {
        log.info("ActionLog.MainCategoryDelete service start");


        mainCategoryRepository.findById(id)
                .orElseThrow(() -> new MainCategoryNotFoundException(HttpStatus.NOT_FOUND.name(), "MainCategory not found"));

        mainCategoryRepository.deleteById(id);

        log.info("ActionLog.MainCategoryDelete service end");

        return ResponseEntity.ok("successfully");


    }
}
