package com.studentshub.service;

import com.studentshub.model.enumerations.EventCategory;
import com.studentshub.model.EventPost;

import java.util.List;

public interface EventPostService {
    EventPost createEventPost(EventPost eventPost);
    List<EventPost> getEventPostsByCategory(EventCategory category);
    EventPost getEventPostById(Long id);
    EventPost updateEventPost(EventPost eventPost);
    void deleteEventPost(Long id);
}

