package com.studentshub.repository;

import com.studentshub.model.HousingPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingPostRepository extends JpaRepository<HousingPost, Long> {
}

