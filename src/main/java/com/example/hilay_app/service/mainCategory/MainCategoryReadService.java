package com.example.hilay_app.service.mainCategory;

import com.example.hilay_app.entity.MainCategory;
import com.example.hilay_app.exception.MainCategoryNotFoundException;
import com.example.hilay_app.mapper.MainCategoryMapper;
import com.example.hilay_app.repository.MainCategoryRepository;
import com.example.hilay_app.response.read.MainCategoryReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainCategoryReadService {

    private final MainCategoryRepository mainCategoryRepository;
    private final MainCategoryMapper mainCategoryMapper;

    public MainCategoryReadResponse read(Long id) {
        log.info("ActionLog.MainCategoryRead service start");

        MainCategory mainCategory = mainCategoryRepository.findById(id)
                .orElseThrow(() -> new MainCategoryNotFoundException(HttpStatus.NOT_FOUND.name(), "MainCategory not found"));

        MainCategoryReadResponse response = mainCategoryMapper.toReadResponse(mainCategory);

        log.info("ActionLog.MainCategoryRead service end");
        return response;
    }

    public List<MainCategoryReadResponse> readAll() {
        log.info("ActionLog.MainCategoryReadAll service start");

        List<MainCategory> mainCategories = mainCategoryRepository.findAll();
        List<MainCategoryReadResponse> responses = mainCategories.stream()
                .map(mainCategoryMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.MainCategoryReadAll service end");
        return responses;
    }
}
