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

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public boolean isWorksOnline() {
        return worksOnline;
    }

    public void setWorksOnline(boolean worksOnline) {
        this.worksOnline = worksOnline;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}