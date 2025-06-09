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
    public EventPost createEventPost(EventPost eventPost) {
        return eventPostRepository.save(eventPost);
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
    public EventPost updateEventPost(EventPost eventPost) {
        return eventPostRepository.save(eventPost);
    }

    @Override
    public void deleteEventPost(Long id) {
        eventPostRepository.deleteById(id);
    }
}

