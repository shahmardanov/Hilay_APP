package com.example.hilay_app.response.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsReadResponse {

    private String questionText;
    private Long fkImageId;
    private long fkLevelId;
    private long fkCardId;
}
