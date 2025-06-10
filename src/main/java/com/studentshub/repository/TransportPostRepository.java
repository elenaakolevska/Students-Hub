package com.studentshub.repository;

import com.studentshub.model.EventPost;
import com.studentshub.model.TransportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportPostRepository extends JpaRepository<TransportPost, Long>, JpaSpecificationExecutor<TransportPost> {
}
