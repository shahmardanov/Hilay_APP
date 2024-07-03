package com.example.hilay_app.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsUpdateRequest {


    private String questionText;
    private Long fkImageId;
    private long fkLevelId;
    private long fkCardId;


}
