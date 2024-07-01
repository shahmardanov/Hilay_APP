package com.example.hilay_app.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryUpdateResponse {


    private String subCategoryName;
    private long fkMainCategoryId;
}