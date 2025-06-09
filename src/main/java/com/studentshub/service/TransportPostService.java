package com.studentshub.service;


import com.studentshub.model.TransportPost;

import java.util.List;

public interface TransportPostService {
    TransportPost create(TransportPost post);
    TransportPost findById(Long id);
    List<TransportPost> findAll();
    TransportPost update(Long id, TransportPost post);
    void delete(Long id);
}
