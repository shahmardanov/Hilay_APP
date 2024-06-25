package com.example.hilay_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question_levels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long levelId;

    @Column(nullable = false)
    private String difficulty;

}
