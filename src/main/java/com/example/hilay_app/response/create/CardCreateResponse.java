package com.example.hilay_app.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateResponse {
    private String title;
    private String content;
    private Long fkImageId;
    private long fkSubCategoryId;
}