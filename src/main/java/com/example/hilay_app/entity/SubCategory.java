package com.example.hilay_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subCategoryId;

    @Column(nullable = false)
    private String subCategoryName;

    @Column(name = "fk_main_category_id", nullable = false)
    private long fkMainCategoryId;
}