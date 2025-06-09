package com.studentshub.service.impl;

import com.studentshub.model.EventPost;
import com.studentshub.model.enumerations.EventCategory;
import com.studentshub.model.exceptions.ResourceNotFoundException;
import com.studentshub.repository.EventPostRepository;
import com.studentshub.service.EventPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventPostServiceImpl implements EventPostService {

    private final EventPostRepository eventPostRepository;

    public EventPostServiceImpl(EventPostRepository eventPostRepository) {
        this.eventPostRepository = eventPostRepository;
    }
    @Override
    public List<EventPost> getAllEventPosts() {
        return eventPostRepository.findAll();
    }

    @Override
    public EventPost createEventPost(EventPost post) {
        EventPost newPost = new EventPost();
        newPost.setCategory(post.getCategory());
        newPost.setLocation(post.getLocation());
        newPost.setFree(post.isFree());
        newPost.setPrice(post.getPrice());
        newPost.setOrganizer(post.getOrganizer());
        newPost.setImageUrl(post.getImageUrl());
        return eventPostRepository.save(newPost);
    }


    @Override
    public List<EventPost> getEventPostsByCategory(EventCategory category) {
        return eventPostRepository.findByCategory(category);
    }

    @Override
    public EventPost getEventPostById(Long id) {
        return eventPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event post not found with id " + id));
    }

    @Override
    public EventPost updateEventPost(Long id, EventPost updatedPost) {
        EventPost existingPost = eventPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventPost not found with id: " + id));

        existingPost.setCategory(updatedPost.getCategory());
        existingPost.setLocation(updatedPost.getLocation());
        existingPost.setFree(updatedPost.isFree());
        existingPost.setPrice(updatedPost.getPrice());
        existingPost.setOrganizer(updatedPost.getOrganizer());
        existingPost.setImageUrl(updatedPost.getImageUrl());

        return eventPostRepository.save(existingPost);
    }

    @Override
    public void deleteEventPost(Long id) {
        eventPostRepository.deleteById(id);
    }
}

