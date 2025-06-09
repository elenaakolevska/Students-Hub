package com.studentshub.model;

import com.studentshub.model.enumerations.EventCategory;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class EventPost extends Post {
    @Enumerated(EnumType.STRING)
    private EventCategory category;
    private String location;
    private boolean isFree;
    @Column(nullable = true)
    private Double price;
    private String organizer;
    private String imageUrl;

}
