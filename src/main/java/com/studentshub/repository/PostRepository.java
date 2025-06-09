package com.studentshub.repository;

import com.studentshub.model.Post;
import com.studentshub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOwner(User owner);

}

