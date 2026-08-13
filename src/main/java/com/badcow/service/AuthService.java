package com.badcow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.badcow.entity.User;
import com.badcow.model.LoginRequestDTO;
import com.badcow.model.RegisterRequestDTO;
import com.badcow.repository.UserRepository;
import com.badcow.utility.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	// REGISTER
	public String register(RegisterRequestDTO request) {

		if (userRepository.existsByEmail(request.getEmail())) {
			return "Email already exists";
		}

		User user = new User();

		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		user.setRole(request.getRole());

//        userRepository.save(user);
//
//        return "Registration Successful";
		User savedUser = userRepository.saveAndFlush(user);

		System.out.println("Saved User ID = " + savedUser.getId());
		System.out.println("Saved User = " + savedUser);

		return "Registration Successful";
	}

	// LOGIN
	public String login(LoginRequestDTO request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

			throw new RuntimeException("Invalid Credentials");
		}

		return jwtUtil.generateToken(user.getEmail());
	}
}