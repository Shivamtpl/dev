package com.badcow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.badcow.entity.User;
import com.badcow.model.LoginRequestDTO;
import com.badcow.model.RegisterRequestDTO;
import com.badcow.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService authService;

	// REGISTER API
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequestDTO request) {

		return authService.register(request);
	}

	// LOGIN API
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {

		String token = authService.login(request);

		return ResponseEntity.ok(token);
	}
}