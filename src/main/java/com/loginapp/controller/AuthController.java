//package com.loginapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import com.loginapp.entity.User;
//import com.loginapp.model.LoginRequestDTO;
//import com.loginapp.repository.UserRepository;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // 🔐 LOGIN
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
//
//        User user = userRepository.findByUsername(request.getUsername())
//                .orElse(null);
//
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("Invalid username");
//        }
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("Invalid password");
//        }
//
//        return ResponseEntity.ok("Login successful");
//    }
//
//    //extra code
//    
//    // 🔑 TEMP PASSWORD ENCODER (REMOVE AFTER USE)
//  @GetMapping("/encode/{password}")
//    public String encode(@PathVariable String password) {
//        return passwordEncoder.encode(password);
//    }
//}
