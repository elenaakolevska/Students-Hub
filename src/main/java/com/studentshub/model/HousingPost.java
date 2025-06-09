package com.studentshub.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class HousingPost extends Post {
    private String municipality;
    private String location;
    private Double price;
    @ElementCollection
    private List<String> images;
    private boolean isFound;
    @ManyToMany
    private List<Tag> tags;
}