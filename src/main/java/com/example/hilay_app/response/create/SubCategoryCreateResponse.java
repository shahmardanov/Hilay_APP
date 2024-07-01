package com.example.hilay_app.response.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryCreateResponse {


    private String subCategoryName;
    private long fkMainCategoryId;
}