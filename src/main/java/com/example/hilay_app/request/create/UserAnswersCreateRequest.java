package com.example.hilay_app.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswersCreateRequest {



    private long fkStudentId;
    private long fkQuestionId;
    private Long fkSelectedAnswerId;
    private Boolean isSkipped;

}