package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByRoomId(Long roomId);
	
	List<Booking> findByRoomOwnerEmail(String ownerEmail);
	
	List<Booking> findByCustomerEmail(String customerEmail);
}
