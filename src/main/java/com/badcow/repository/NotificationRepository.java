package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Notification;

public interface NotificationRepository
        extends JpaRepository<Notification,Long>{

    List<Notification> findByUserEmailOrderByCreatedAtDesc(
            String userEmail);

}