package com.badcow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.entity.Favorite;
import com.badcow.repository.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;

	public Favorite addFavorite(Favorite favorite) {
		return favoriteRepository.save(favorite);
	}

	public List<Favorite> getFavorites(String email) {
		return favoriteRepository.findByUserEmail(email);
	}
}