package com.studentshub.service;

import com.studentshub.model.TransportPost;
import com.studentshub.model.TutorPost;

import java.util.List;

public interface TutorPostService {
    TutorPost create(TutorPost post);
    TutorPost findById(Long id);
    List<TutorPost> findAll();
    TutorPost update(Long id, TutorPost post);
    void delete(Long id);
}
