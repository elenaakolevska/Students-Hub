package com.studentshub.service;

import com.studentshub.model.Post;
import com.studentshub.model.User;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getPostsByOwner(User owner);
    Post updatePost(Post post);
    void deletePost(Long id);
}

