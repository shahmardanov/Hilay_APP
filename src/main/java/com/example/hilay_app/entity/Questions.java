package com.example.hilay_app.entity;

import jakarta.annotation.Nullable;
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

    @Column(name = "fk_sub_category_id", nullable = false)
    private long fkSubCategoryId;

}
