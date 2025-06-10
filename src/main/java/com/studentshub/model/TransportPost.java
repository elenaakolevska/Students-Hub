package com.studentshub.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class TransportPost extends Post {
    private LocalDateTime departureDatetime;
    private String providerName;
    private String locationFrom;
    private String locationTo;
    private Double price;

    public TransportPost(LocalDateTime departureDatetime, String providerName, String locationFrom, String locationTo, Double price) {
        this.departureDatetime = departureDatetime;
        this.providerName = providerName;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.price = price;
    }

    public TransportPost() {
    }

    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(LocalDateTime departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}