package com.studentshub.service.impl;

import com.studentshub.model.MaterialPost;
import com.studentshub.model.User;
import com.studentshub.model.exceptions.PostNotFoundException;
import com.studentshub.model.exceptions.ResourceNotFoundException;
import com.studentshub.repository.MaterialPostRepository;
import com.studentshub.service.MaterialPostService;
import com.studentshub.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialPostServiceImpl implements MaterialPostService {

    private final MaterialPostRepository repository;
    private final UserService userService;

    public MaterialPostServiceImpl(MaterialPostRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public MaterialPost create(MaterialPost post, String username) {
        User owner = userService.getUserByUsername(username);

        MaterialPost newPost = new MaterialPost();
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        newPost.setCategory(post.getCategory());
        newPost.setRating(post.getRating());
        newPost.setFileUrl(post.getFileUrl());
        newPost.setOriginalFileName(post.getOriginalFileName());

        newPost.setTags(post.getTags());

        newPost.setOwner(owner);
        newPost.setCreatedAt(LocalDateTime.now());

        return repository.save(newPost);
    }

    @Override
    public MaterialPost findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public List<MaterialPost> findAll() {
        return repository.findAll();
    }

    @Override
    public MaterialPost update(Long id, MaterialPost updatedPost) {
        MaterialPost existingPost = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MaterialPost not found with id: " + id));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setDescription(updatedPost.getDescription());
        existingPost.setCategory(updatedPost.getCategory());
        existingPost.setRating(updatedPost.getRating());
        existingPost.setOriginalFileName(updatedPost.getOriginalFileName());
        existingPost.setFileUrl(updatedPost.getFileUrl());
        existingPost.setTags(updatedPost.getTags());

        return repository.save(existingPost);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
