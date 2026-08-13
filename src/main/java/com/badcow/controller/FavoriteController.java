package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badcow.entity.Favorite;
import com.badcow.service.FavoriteService;
import com.badcow.service.FileUploadService;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;


	@PostMapping
	public Favorite addFavorite(@RequestBody Favorite favorite) {

		return favoriteService.addFavorite(favorite);
	}

	@GetMapping("/{email}")
	public List<Favorite> getFavorites(@PathVariable String email) {

		return favoriteService.getFavorites(email);
	}

}