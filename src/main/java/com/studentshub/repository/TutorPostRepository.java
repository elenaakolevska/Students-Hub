package com.studentshub.repository;

import com.studentshub.model.TutorPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorPostRepository extends JpaRepository<TutorPost, Long> {
}

