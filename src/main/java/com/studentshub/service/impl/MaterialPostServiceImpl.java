package com.studentshub.service.impl;

import com.studentshub.model.MaterialPost;
import com.studentshub.model.exceptions.PostNotFoundException;
import com.studentshub.model.exceptions.ResourceNotFoundException;
import com.studentshub.repository.MaterialPostRepository;
import com.studentshub.service.MaterialPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialPostServiceImpl implements MaterialPostService {

    private final MaterialPostRepository repository;

    public MaterialPostServiceImpl(MaterialPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaterialPost create(MaterialPost post) {
        MaterialPost newPost = new MaterialPost();
        newPost.setRating(post.getRating());
        newPost.setFileUrl(post.getFileUrl());
        newPost.setTags(post.getTags());
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

        existingPost.setRating(updatedPost.getRating());
        existingPost.setFileUrl(updatedPost.getFileUrl());
        existingPost.setTags(updatedPost.getTags());

        return repository.save(existingPost);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
