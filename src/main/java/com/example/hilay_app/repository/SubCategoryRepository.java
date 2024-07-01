package com.example.hilay_app.repository;

import com.example.hilay_app.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {


    List<SubCategory> findByFkMainCategoryId(Long id);
    List<SubCategory> findBySubCategoryName(String name);
}
