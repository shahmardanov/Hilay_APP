package com.example.hilay_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long responseId;

    @Column(nullable = false)
    private long fkStudentId;

    @Column(nullable = false)
    private long fkQuestionId;

    private Long fkSelectedAnswerId;

    @Column(nullable = false)
    private Boolean isSkipped;

}