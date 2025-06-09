package com.studentshub.service.impl;

import com.studentshub.model.TutorPost;
import com.studentshub.model.exceptions.PostNotFoundException;
import com.studentshub.repository.TutorPostRepository;
import com.studentshub.service.TutorPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorPostServiceImpl implements TutorPostService {

    private final TutorPostRepository repository;

    public TutorPostServiceImpl(TutorPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public TutorPost create(TutorPost post) {
        TutorPost newPost = new TutorPost();
        newPost.setTutorName(post.getTutorName());
        newPost.setFaculty(post.getFaculty());
        newPost.setWorksOnline(post.isWorksOnline());
        newPost.setPrice(post.getPrice());
        newPost.setTags(post.getTags());
        return repository.save(newPost);
    }


    @Override
    public TutorPost findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public List<TutorPost> findAll() {
        return repository.findAll();
    }

    @Override
    public TutorPost update(Long id, TutorPost updatedPost) {
        TutorPost existingPost = repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        existingPost.setTutorName(updatedPost.getTutorName());
        existingPost.setFaculty(updatedPost.getFaculty());
        existingPost.setWorksOnline(updatedPost.isWorksOnline());
        existingPost.setPrice(updatedPost.getPrice());
        existingPost.setTags(updatedPost.getTags());

        return repository.save(existingPost);
    }


    @Override
    public void delete(Long id) {

    }
}
