package com.example.hilay_app.response.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AnswersReadResponse {

    private long fkQuestionId;
    private Boolean isCorrect;

    private String answerText;

}
