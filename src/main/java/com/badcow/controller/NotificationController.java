package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.badcow.entity.Notification;
import com.badcow.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public Notification save(
            @RequestBody Notification notification){

        return service.save(notification);

    }

    @GetMapping("/{email}")
    public List<Notification> get(
            @PathVariable String email){

        return service.getNotifications(email);

    }

}