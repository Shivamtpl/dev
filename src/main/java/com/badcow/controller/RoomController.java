package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.badcow.entity.Room;
import com.badcow.service.FileUploadService;
import com.badcow.service.RoomService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rooms")
@CrossOrigin("*")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping
	public Room addRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@GetMapping
	public List<Room> getRooms() {
		return roomService.getAllRooms();
	}

	// room details
	@GetMapping("/location/{location}")
	public List<Room> getByLocation(@PathVariable String location) {

		return roomService.searchByLocation(location);
	}

	@GetMapping("/type/{type}")
	public List<Room> getByType(@PathVariable String type) {

		return roomService.searchByRoomType(type);
	}

	@GetMapping("/rent/{rent}")
	public List<Room> getByRent(@PathVariable double rent) {

		return roomService.searchByRent(rent);
	}

	@GetMapping("/search")
	public List<Room> search(@RequestParam String location, @RequestParam String type) {

		return roomService.searchLocationAndType(location, type);
	}

	@PostMapping(
	        value = "/{id}/upload",
	        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	public Room uploadImage(
	        @PathVariable Long id,
	        @RequestParam("file") MultipartFile file)
	        throws Exception {

	    String fileName =
	            fileUploadService.uploadFile(file);

	    return roomService.updateImage(
	            id,
	            fileName
	    );
	}
	
	@PutMapping("/{id}")
	public Room updateRoom(
	        @PathVariable Long id,
	        @RequestBody Room room){

	    return roomService
	            .updateRoom(id, room);
	}

	@DeleteMapping("/{id}")
	public String deleteRoom(
	        @PathVariable Long id){

	    roomService.deleteRoom(id);

	    return "Room Deleted";
	}
	
	@GetMapping("/owner/{email}")
	public List<Room> getRoomsByOwner(
	        @PathVariable String email) {

	    return roomService.getRoomsByOwner(email);
	}
	@GetMapping("/{id}")
	public Room getRoomById(@PathVariable Long id) {
	    return roomService.getRoomById(id);
	}
}
