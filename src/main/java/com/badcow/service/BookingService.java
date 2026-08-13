
package com.badcow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.entity.Booking;
import com.badcow.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking saveBooking(Booking booking) {
		booking.setStatus("PENDING");
		return bookingRepository.save(booking);
	}

	// Get all bookings
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	// Get bookings by room
	public List<Booking> getBookingsByRoom(Long roomId) {
		return bookingRepository.findByRoomId(roomId);
	}

	// Approve booking
	public Booking approveBooking(Long id) {

		Booking booking = bookingRepository.findById(id).orElseThrow();

		booking.setStatus("APPROVED");

		return bookingRepository.save(booking);
	}

	// Reject booking
	public Booking rejectBooking(Long id) {

		Booking booking = bookingRepository.findById(id).orElseThrow();

		booking.setStatus("REJECTED");

		return bookingRepository.save(booking);
	}

	public List<Booking> getBookingsByOwner(
	        String ownerEmail) {

	    return bookingRepository
	            .findByRoomOwnerEmail(ownerEmail);
	}
	public List<Booking> getBookingsByCustomer(
	        String customerEmail) {

	    return bookingRepository
	            .findByCustomerEmail(customerEmail);
	}
}
