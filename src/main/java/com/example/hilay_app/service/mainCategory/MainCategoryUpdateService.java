package com.example.hilay_app.service.mainCategory;

import com.example.hilay_app.entity.MainCategory;
import com.example.hilay_app.exception.MainCategoryNotFoundException;
import com.example.hilay_app.mapper.MainCategoryMapper;
import com.example.hilay_app.repository.MainCategoryRepository;
import com.example.hilay_app.request.update.MainCategoryUpdateRequest;
import com.example.hilay_app.response.update.MainCategoryUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainCategoryUpdateService {

    private final MainCategoryRepository mainCategoryRepository;
    private final MainCategoryMapper mainCategoryMapper;

    public MainCategoryUpdateResponse update(Long id, MainCategoryUpdateRequest request) {
        log.info("ActionLog.MainCategoryUpdate service start");

        MainCategory mainCategory = mainCategoryRepository.findById(id)
                .orElseThrow(() -> new MainCategoryNotFoundException(HttpStatus.NOT_FOUND.name(), "MainCategory not found"));

        mainCategoryMapper.updateMainCategoryFromRequest(request, mainCategory);
        MainCategory updatedMainCategory = mainCategoryRepository.save(mainCategory);
        MainCategoryUpdateResponse response = mainCategoryMapper.toUpdateResponse(updatedMainCategory);

        log.info("ActionLog.MainCategoryUpdate service end");
        return response;
    }
}
