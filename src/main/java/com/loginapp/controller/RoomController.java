//package com.loginapp.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.Principal;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.loginapp.entity.Room;
//import com.loginapp.entity.User;
//import com.loginapp.repository.RoomRepository;
//import com.loginapp.repository.UserRepository;
//
//@RestController
//@RequestMapping("/rooms")
//public class RoomController {
//
//    @Autowired
//    private RoomRepository roomRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/images/{imageName}")
//    public ResponseEntity<Resource> getImage(@PathVariable String imageName)
//            throws IOException {
//
//        Path path = Paths.get("uploads/rooms/" + imageName);
//        Resource resource = new UrlResource(path.toUri());
//
//        return ResponseEntity.ok()
//                .header("Content-Type", "image/jpeg")
//                .body(resource);
//    }
//
//    // ADD ROOM (LOGIN REQUIRED)
//    @PostMapping("/add")
//    public String addRoom(
//            @RequestParam String title,
//            @RequestParam String city,
//            @RequestParam Double price,
//            @RequestParam String roomType,
//            @RequestParam MultipartFile image,
//            Principal principal) throws IOException {
//
//        User owner = userRepository
//                .findByUsername(principal.getName())
//                .orElseThrow();
//
//        String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
//        Path path = Paths.get("uploads/rooms/" + fileName);
//        Files.createDirectories(path.getParent());
//        Files.copy(image.getInputStream(), path);
//
//        Room room = new Room();
//        room.setTitle(title);
//        room.setCity(city);
//        room.setPrice(price);
//        room.setRoomType(roomType);
//        room.setImageName(fileName);
//        room.setOwner(owner);
//
//        roomRepository.save(room);
//
//        return "Room added successfully";
//    }
//
//    // PUBLIC ROOM LIST
//    @GetMapping
//    public List<Room> getRooms() {
//        return roomRepository.findAll();
//    }
//}
