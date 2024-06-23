package com.example.hilay_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(name = "fk_question_id", nullable = false)
    private long questionId;

    @Column(nullable = false)
    private String answerText;

    @Column(nullable = false)
    private Boolean isCorrect;

}
