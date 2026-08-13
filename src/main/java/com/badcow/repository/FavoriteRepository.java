package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Favorite;

public interface FavoriteRepository
        extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUserEmail(String userEmail);
}