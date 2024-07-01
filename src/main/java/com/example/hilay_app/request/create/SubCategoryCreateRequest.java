package com.example.hilay_app.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryCreateRequest {


    private String subCategoryName;
    private long fkMainCategoryId;
}