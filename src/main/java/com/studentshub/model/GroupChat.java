package com.studentshub.model;

import jakarta.persistence.*;

@Entity
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User createdBy;
}