package com.studentshub.model;

import com.studentshub.model.enumerations.PostCategory;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    @ManyToOne
    private User owner;

    @Enumerated(EnumType.STRING)
    private PostCategory category;
}
