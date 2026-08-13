package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.badcow.entity.Booking;
import com.badcow.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public Booking bookRoom(@RequestBody Booking booking) {

		return bookingService.saveBooking(booking);
	}
	@GetMapping
	public List<Booking> getAllBookings(){
	    return bookingService.getAllBookings();
	}

	@GetMapping("/room/{roomId}")
	public List<Booking> getByRoom(
	        @PathVariable Long roomId){

	    return bookingService
	            .getBookingsByRoom(roomId);
	}

	@PutMapping("/{id}/approve")
	public Booking approve(
	        @PathVariable Long id){

	    return bookingService
	            .approveBooking(id);
	}

	@PutMapping("/{id}/reject")
	public Booking reject(
	        @PathVariable Long id){

	    return bookingService
	            .rejectBooking(id);
	}
	
	@GetMapping("/owner/{email}")
	public List<Booking> getOwnerBookings(
	        @PathVariable String email) {

	    return bookingService
	            .getBookingsByOwner(email);
	}
	@GetMapping("/customer/{email}")
	public List<Booking> getCustomerBookings(
	        @PathVariable String email) {

	    return bookingService
	            .getBookingsByCustomer(email);
	}
}