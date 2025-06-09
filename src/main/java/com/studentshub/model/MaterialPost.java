package com.studentshub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class MaterialPost extends Post {
    private Double rating;
    private String fileUrl;
    @ManyToMany
    private List<Tag> tags;
}
