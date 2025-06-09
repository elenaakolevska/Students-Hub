package com.studentshub.repository;

import com.studentshub.model.InternshipPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipPostRepository extends JpaRepository<InternshipPost, Long> {
}

