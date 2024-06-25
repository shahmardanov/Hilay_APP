package com.example.hilay_app.repository;

import com.example.hilay_app.entity.QuestionsLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsLevelRepository extends JpaRepository<QuestionsLevel,Long> {
}
