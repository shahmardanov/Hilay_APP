package com.example.hilay_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "questions")
@Entity
public class Questions {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long questionId;

    @Column(nullable = false)
    private String questionText;
    private Long fkImageId;

    @Column(name = "fk_level_id")
    private long fkLevelId;

    @Column(name = "fk_card_id", nullable = false)
    private long fkCardId;

}
