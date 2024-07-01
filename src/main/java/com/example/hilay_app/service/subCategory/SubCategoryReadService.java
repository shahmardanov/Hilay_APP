package com.example.hilay_app.service.subCategory;

import com.example.hilay_app.entity.SubCategory;
import com.example.hilay_app.exception.SubCategoryNotFoundException;
import com.example.hilay_app.mapper.SubCategoryMapper;
import com.example.hilay_app.repository.SubCategoryRepository;
import com.example.hilay_app.response.read.SubCategoryReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryReadService {


    private final SubCategoryRepository subCategoryRepository;


    private final SubCategoryMapper subCategoryMapper;

    public List<SubCategoryReadResponse> getAllSubCategories() {

        log.info("ActionLog.getAllSubCategories start");

        List<SubCategory> subCategories = subCategoryRepository.findAll();

        log.info("ActionLog.getAllSubCategories end");

        return subCategories.stream()
                .map(subCategoryMapper::toReadResponse)
                .collect(Collectors.toList());
    }
    
    public SubCategoryReadResponse getSubCategoryById(long id) {

        log.info("ActionLog.getSubCategoryById start");

        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new  SubCategoryNotFoundException(HttpStatus.NOT_FOUND.name(),"SubCategory not found"));

        log.info("ActionLog.getSubCategoryById end");

        return subCategoryMapper.toReadResponse(subCategory);
    }



    public List<SubCategoryReadResponse> readByFkMainCategoryId(long fkMainCategoryId) {
        log.info("ActionLog.SubCategoryReadByFkMainCategoryId service start");

        List<SubCategory> subCategories = subCategoryRepository.findByFkMainCategoryId(fkMainCategoryId);
        List<SubCategoryReadResponse> responses = subCategories.stream()
                .map(subCategoryMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.SubCategoryReadByFkMainCategoryId service end");
        return responses;
    }

    public List<SubCategoryReadResponse> readBySubCategoryName(String subCategoryName) {
        log.info("ActionLog.SubCategoryReadBySubCategoryName service start");

        List<SubCategory> subCategories = subCategoryRepository.findBySubCategoryName(subCategoryName);
        List<SubCategoryReadResponse> responses = subCategories.stream()
                .map(subCategoryMapper::toReadResponse)
                .collect(Collectors.toList());

        log.info("ActionLog.SubCategoryReadBySubCategoryName service end");
        return responses;
    }

}
