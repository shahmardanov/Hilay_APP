package com.example.hilay_app.response.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswersCreateResponse {

   

    private long fkStudentId;
    private long fkQuestionId;
    private Long fkSelectedAnswerId;
    private Boolean isSkipped;

}