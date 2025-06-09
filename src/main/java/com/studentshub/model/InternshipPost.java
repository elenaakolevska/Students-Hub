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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFacultyFilter() {
        return facultyFilter;
    }

    public void setFacultyFilter(String facultyFilter) {
        this.facultyFilter = facultyFilter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
