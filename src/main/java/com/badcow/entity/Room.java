package com.badcow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String location;

    private double rent;

    private String roomType;

    @Column(length = 1000)
    private String description;

    private String imageUrl;

    private boolean available = true;

    private String ownerEmail;
    
    private Double latitude;

    private Double longitude;
}