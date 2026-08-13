package com.badcow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;

    private Double amount;

    private String paymentId;

    private String orderId;

    private String status;

    private LocalDateTime paymentDate = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}