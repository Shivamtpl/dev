package com.badcow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.entity.Notification;
import com.badcow.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public Notification save(Notification notification){
        return repository.save(notification);
    }

    public List<Notification> getNotifications(String email){
        return repository.findByUserEmailOrderByCreatedAtDesc(email);
    }

}