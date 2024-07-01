package com.example.hilay_app.service.subCategory;

import com.example.hilay_app.entity.SubCategory;
import com.example.hilay_app.mapper.SubCategoryMapper;
import com.example.hilay_app.repository.SubCategoryRepository;
import com.example.hilay_app.request.create.SubCategoryCreateRequest;
import com.example.hilay_app.response.create.SubCategoryCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryCreateService {


    private final SubCategoryRepository subCategoryRepository;


    private  final SubCategoryMapper subCategoryMapper;

    public SubCategoryCreateResponse create(SubCategoryCreateRequest request) {

        log.info("ActionLog.SubCategoryCreate start");

        SubCategory subCategory = subCategoryMapper.toEntity(request);
        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);

        log.info("ActionLog.SubCategoryCreate end");

        return subCategoryMapper.toCreateResponse(savedSubCategory);
    }
}
