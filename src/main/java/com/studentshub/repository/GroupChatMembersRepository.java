package com.studentshub.repository;

import com.studentshub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupChatMembersRepository extends JpaRepository<GroupChatMembers, Long>,JpaSpecificationRepository<GroupChatMembers,Long> {
    List<GroupChatMembers> findByUser(User user);
}
