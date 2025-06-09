package com.studentshub.service;

import com.studentshub.model.HousingPost;

import java.util.List;

public interface HousingPostService {
    HousingPost create(HousingPost post);
    HousingPost findById(Long id);
    List<HousingPost> findAll();
    HousingPost update(Long id, HousingPost post);
    void delete(Long id);
}

