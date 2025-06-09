package com.studentshub.repository;


import com.studentshub.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>,JpaSpecificationRepository<Tag,Long> {
    Optional<Tag> findByName(String name);
}