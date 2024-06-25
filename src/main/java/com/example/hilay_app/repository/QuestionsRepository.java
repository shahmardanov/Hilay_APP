package com.example.hilay_app.repository;

import com.example.hilay_app.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long> {
}
