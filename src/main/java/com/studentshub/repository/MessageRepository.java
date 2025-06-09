package com.studentshub.repository;


import com.studentshub.model.GroupChat;
import com.studentshub.model.Message;
import com.studentshub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>,JpaSpecificationRepository<Message,Long> {
    List<Message> findBySenderOrReceiver(User sender, User receiver);
    List<Message> findByGroup(GroupChat group);
}