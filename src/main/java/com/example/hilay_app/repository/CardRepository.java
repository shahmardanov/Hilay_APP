package com.example.hilay_app.repository;

import com.example.hilay_app.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findByTitle(String title);
    Optional<Card> findByContent(String content);
    List<Card> findByFkImageId(Long fkImageId);
    List<Card> findByFkSubCategoryId(long fkSubCategoryId);
}
