package com.example.hilay_app.response.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AnswersCreateResponse {

    private long fkQuestionId;
    private Boolean isCorrect;

    private String answerText;

}
