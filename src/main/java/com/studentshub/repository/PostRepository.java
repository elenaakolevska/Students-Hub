package com.studentshub.repository;

import com.studentshub.model.Post;
import com.studentshub.model.User;
import com.studentshub.model.enumerations.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOwner(User owner);
    Optional<Post> findTopByCategoryOrderByCreatedAtDesc(PostCategory category);

}

