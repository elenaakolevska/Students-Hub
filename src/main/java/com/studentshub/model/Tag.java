package com.studentshub.model;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;
}

