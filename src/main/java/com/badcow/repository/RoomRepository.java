package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Room;

public interface RoomRepository  extends JpaRepository<Room, Long> {

	 List<Room> findByLocationContainingIgnoreCase(String location);

	    List<Room> findByRoomTypeIgnoreCase(String roomType);

	    List<Room> findByRentLessThanEqual(double rent);

	    List<Room> findByLocationContainingIgnoreCaseAndRoomTypeIgnoreCase(
	            String location,
	            String roomType);
	    
	    List<Room> findByOwnerEmail(String ownerEmail);
}
