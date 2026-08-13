package com.badcow.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String customerName;

	private String customerEmail;

	private String customerPhone;

	private LocalDate bookingDate;

	private String status;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	
}