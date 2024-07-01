package com.example.hilay_app.service.subCategory;

import com.example.hilay_app.entity.SubCategory;
import com.example.hilay_app.exception.SubCategoryNotFoundException;
import com.example.hilay_app.mapper.SubCategoryMapper;
import com.example.hilay_app.repository.SubCategoryRepository;
import com.example.hilay_app.request.update.SubCategoryUpdateRequest;
import com.example.hilay_app.response.update.SubCategoryUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryUpdateService {


    private final SubCategoryRepository subCategoryRepository;

    private final SubCategoryMapper subCategoryMapper;

    public SubCategoryUpdateResponse update(long id, SubCategoryUpdateRequest request) {

        log.info("ActionLog.SubCategoriesUpdate start");

        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new  SubCategoryNotFoundException(HttpStatus.NOT_FOUND.name(),"SubCategory not found"));
        subCategoryMapper.updateEntityFromRequest(request, subCategory);
        SubCategory updatedSubCategory = subCategoryRepository.save(subCategory);

        log.info("ActionLog.SubCategoriesUpdate end");

        return subCategoryMapper.toUpdateResponse(updatedSubCategory);
    }
}
