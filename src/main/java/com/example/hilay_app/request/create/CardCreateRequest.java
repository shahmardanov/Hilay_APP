package com.example.hilay_app.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateRequest {

    private String title;
    private String content;
    private Long fkImageId;
    private long fkSubCategoryId;
}