package com.example.hilay_app.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionCreateRequest {
    private String questionText;
    private Long fkImageId;
    private long fkLevelId;
    private long fkCardId;
}
