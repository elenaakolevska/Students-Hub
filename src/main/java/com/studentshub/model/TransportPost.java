package com.studentshub.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class TransportPost extends Post {
    private LocalDateTime departureDatetime;
    private String providerName;
    private String locationFrom;
    private String locationTo;
    private Double price;
}