package com.example.hilay_app.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AnswersCreateRequest {

    private long fkQuestionId;

    private String answerText;
    private Boolean isCorrect;


}
