package com.studentshub.repository;


import com.studentshub.model.EventPost;
import com.studentshub.model.enumerations.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventPostRepository extends JpaRepository<EventPost, Long>,JpaSpecificationRepository<EventPost,Long> {
    List<EventPost> findByCategory(EventCategory category);

}
