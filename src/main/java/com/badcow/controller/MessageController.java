package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.badcow.entity.Message;
import com.badcow.service.MessageService;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public Message send(
            @RequestBody Message message){

        return service.send(message);

    }

    @GetMapping
    public List<Message> chat(
            @RequestParam String user1,
            @RequestParam String user2){

        return service.conversation(user1,user2);

    }

}