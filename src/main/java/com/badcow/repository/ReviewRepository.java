package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRoomId(Long roomId);

}