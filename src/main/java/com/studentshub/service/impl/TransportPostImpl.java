package com.studentshub.service.impl;

import com.studentshub.model.TransportPost;
import com.studentshub.model.exceptions.PostNotFoundException;
import com.studentshub.model.exceptions.ResourceNotFoundException;
import com.studentshub.repository.TransportPostRepository;
import com.studentshub.service.TransportPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportPostImpl implements TransportPostService {

    private final TransportPostRepository repository;

    public TransportPostImpl(TransportPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransportPost create(TransportPost post) {
        TransportPost newPost = new TransportPost();
        newPost.setDepartureDatetime(post.getDepartureDatetime());
        newPost.setProviderName(post.getProviderName());
        newPost.setLocationFrom(post.getLocationFrom());
        newPost.setLocationTo(post.getLocationTo());
        newPost.setPrice(post.getPrice());
        return repository.save(post);

    }

    @Override
    public TransportPost findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));

    }

    @Override
    public List<TransportPost> findAll() {
        return repository.findAll();
    }

    @Override
    public TransportPost update(Long id, TransportPost updatedPost) {
        TransportPost existingPost = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TransportPost not found with id: " + id));

        existingPost.setDepartureDatetime(updatedPost.getDepartureDatetime());
        existingPost.setProviderName(updatedPost.getProviderName());
        existingPost.setLocationFrom(updatedPost.getLocationFrom());
        existingPost.setLocationTo(updatedPost.getLocationTo());
        existingPost.setPrice(updatedPost.getPrice());

        return repository.save(existingPost);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
