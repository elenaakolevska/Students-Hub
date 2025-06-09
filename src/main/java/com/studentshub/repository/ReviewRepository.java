package com.studentshub.repository;


import com.studentshub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>,JpaSpecificationRepository<Review,Long> {
    List<Review> findByPost(Post post);
}