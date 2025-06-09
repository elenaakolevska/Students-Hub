package com.studentshub.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class InternshipPost extends Post {
    private String company;
    private String facultyFilter;
    private String position;
    private String logoUrl;
}
