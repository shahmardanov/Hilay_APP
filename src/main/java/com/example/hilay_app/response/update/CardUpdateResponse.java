package com.example.hilay_app.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardUpdateResponse {

    private String title;
    private String content;
    private Long fkImageId;
    private long fkSubCategoryId;
}