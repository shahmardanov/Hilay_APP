package com.example.hilay_app.service.mainCategory;

import com.example.hilay_app.entity.MainCategory;
import com.example.hilay_app.exception.MainCategoryExistsException;
import com.example.hilay_app.mapper.MainCategoryMapper;
import com.example.hilay_app.repository.MainCategoryRepository;
import com.example.hilay_app.request.create.MainCategoryCreateRequest;
import com.example.hilay_app.response.create.MainCategoryCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainCategoryCreateService {

    private final MainCategoryRepository mainCategoryRepository;
    private final MainCategoryMapper mainCategoryMapper;

    public MainCategoryCreateResponse create(MainCategoryCreateRequest request) {
        log.info("ActionLog.MainCategoryCreate service start");

        if (mainCategoryRepository.findByMainCategoryName(request.getMainCategoryName()) != null) {
            throw new MainCategoryExistsException(HttpStatus.CONFLICT.name(), "MainCategory already exists");
        }

        MainCategory mainCategory = mainCategoryMapper.toMainCategory(request);
        MainCategory savedMainCategory = mainCategoryRepository.save(mainCategory);
        MainCategoryCreateResponse response = mainCategoryMapper.toCreateResponse(savedMainCategory);

        log.info("ActionLog.MainCategoryCreate service end");
        return response;
    }
}
