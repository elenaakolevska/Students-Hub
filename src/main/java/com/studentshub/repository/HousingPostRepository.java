package com.studentshub.repository;

import com.studentshub.model.EventPost;
import com.studentshub.model.HousingPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingPostRepository extends JpaRepository<HousingPost, Long>, JpaSpecificationExecutor<HousingPost> {
}

