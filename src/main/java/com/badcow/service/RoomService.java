package com.badcow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.entity.Room;
import com.badcow.repository.RoomRepository;

@Service
public class RoomService {

	  @Autowired
	    private RoomRepository roomRepository;

//	    public Room saveRoom(Room room) {
//	        return roomRepository.save(room);
//	    }
	  public Room saveRoom(Room room) {

		    Room saved = roomRepository.save(room);

		    System.out.println(saved.getId());
		    System.out.println(saved.getTitle());

		    return saved;
		}

	    public List<Room> getAllRooms() {
	        return roomRepository.findAll();
	    }
	    public List<Room> searchByLocation(String location){
	        return roomRepository
	                .findByLocationContainingIgnoreCase(location);
	    }

	    public List<Room> searchByRoomType(String roomType){
	        return roomRepository
	                .findByRoomTypeIgnoreCase(roomType);
	    }

	    public List<Room> searchByRent(double rent){
	        return roomRepository
	                .findByRentLessThanEqual(rent);
	    }

	    public List<Room> searchLocationAndType(
	            String location,
	            String roomType){

	        return roomRepository
	                .findByLocationContainingIgnoreCaseAndRoomTypeIgnoreCase(
	                        location,
	                        roomType);
	    }
	    
	    public Room updateRoom(
	            Long id,
	            Room room){

	        Room existing =
	                roomRepository
	                .findById(id)
	                .orElseThrow();

	        existing.setTitle(room.getTitle());
	        existing.setLocation(room.getLocation());
	        existing.setRent(room.getRent());
	        existing.setRoomType(room.getRoomType());
	        existing.setDescription(room.getDescription());
	        existing.setImageUrl(room.getImageUrl());
	        existing.setAvailable(room.isAvailable());

	        return roomRepository.save(existing);
	    }

	   	    public Room getRoomById(Long id) {
	        return roomRepository.findById(id)
	                .orElseThrow(() ->
	                    new RuntimeException("Room not found with id: " + id));
	    }
	   	 public void deleteRoom(Long id){
		        roomRepository.deleteById(id);
		    }
	   	public List<Room> getRoomsByOwner(
	   	        String ownerEmail) {

	   	    return roomRepository
	   	            .findByOwnerEmail(ownerEmail);
	   	}
	   	public Room updateImage(
	   	        Long id,
	   	        String imageUrl) {

	   	    Room room = roomRepository
	   	            .findById(id)
	   	            .orElseThrow(() ->
	   	                    new RuntimeException(
	   	                            "Room not found with id: " + id
	   	                    ));

	   	    room.setImageUrl(imageUrl);

	   	    return roomRepository.save(room);
	   	}
}
