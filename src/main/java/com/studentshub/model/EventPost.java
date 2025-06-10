package com.studentshub.model;

import com.studentshub.model.enumerations.EventCategory;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
//@NoArgsConstructor
public class EventPost extends Post {
    @Enumerated(EnumType.STRING)
    private EventCategory category;
    private String location;
    private boolean isFree;
    @Column(nullable = true)
    private Double price;
    private String organizer;
    private String imageUrl;

    public EventPost() {
    }

    public EventPost(EventCategory category, String location, boolean isFree, Double price, String organizer, String imageUrl) {
        this.category = category;
        this.location = location;
        this.isFree = isFree;
        this.price = price;
        this.organizer = organizer;
        this.imageUrl = imageUrl;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
