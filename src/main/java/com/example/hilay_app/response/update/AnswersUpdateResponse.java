package com.example.hilay_app.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AnswersUpdateResponse {

    private long fkQuestionId;
    private Boolean isCorrect;
    private String answerText;

}
