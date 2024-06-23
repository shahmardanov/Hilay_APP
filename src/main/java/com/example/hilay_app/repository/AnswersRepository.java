package com.example.hilay_app.repository;

import com.example.hilay_app.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answers,Long> {
}
