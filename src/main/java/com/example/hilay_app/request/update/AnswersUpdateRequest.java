package com.example.hilay_app.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AnswersUpdateRequest {

    private long fkQuestionId;
    private Boolean isCorrect;
    private String answerText;

}
