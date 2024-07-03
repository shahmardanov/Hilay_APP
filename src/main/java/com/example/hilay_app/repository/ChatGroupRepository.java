package com.example.hilay_app.repository;

import com.example.hilay_app.entity.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {

    ChatGroup findByName(String name);
}
