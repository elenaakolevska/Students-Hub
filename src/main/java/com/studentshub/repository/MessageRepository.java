package com.studentshub.repository;


import com.studentshub.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>,JpaSpecificationRepository<Message,Long> {
    List<Message> findBySenderOrReceiver(User sender, User receiver);
}