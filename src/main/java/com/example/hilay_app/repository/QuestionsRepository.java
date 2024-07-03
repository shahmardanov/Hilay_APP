package com.example.hilay_app.repository;

import com.example.hilay_app.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long> {

    List<Questions> findByFkImageId (Long imageId);
    List<Questions>findByFkLevelId (Long levelId);
    List<Questions>findByFkCardId (Long cardId);
}
