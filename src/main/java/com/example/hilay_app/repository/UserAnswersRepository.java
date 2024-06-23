package com.example.hilay_app.repository;

import com.example.hilay_app.entity.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswersRepository extends JpaRepository<UserAnswers,Long> {
}
