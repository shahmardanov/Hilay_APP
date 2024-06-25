package com.example.hilay_app.repository;

import com.example.hilay_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFkGroupId(Long fkGroupId);
    Student findByUsername(String username);

    @Query("SELECT s FROM Student s JOIN ChatGroup g ON s.fkGroupId = g.id WHERE g.name = :groupName")
    List<Student> findByGroupName(@Param("groupName") String groupName);
}
