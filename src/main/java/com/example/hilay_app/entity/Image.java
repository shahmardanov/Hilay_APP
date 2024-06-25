package com.example.hilay_app.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String fileName;
    @Column(columnDefinition = "TEXT")
    private String filePath;

}
