package com.studentshub.repository;

import com.studentshub.model.EventPost;
import com.studentshub.model.MaterialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialPostRepository extends JpaRepository<MaterialPost, Long>, JpaSpecificationExecutor<MaterialPost> {
}

