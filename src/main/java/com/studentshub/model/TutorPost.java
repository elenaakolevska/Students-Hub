package com.studentshub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class TutorPost extends Post {
    private String tutorName;
    private String faculty;
    private boolean worksOnline;
    private Double price;

    @ManyToMany
    private List<Tag> tags;
}