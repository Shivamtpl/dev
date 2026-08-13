package com.badcow.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.entity.Message;
import com.badcow.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public Message send(Message message) {

        return repository.save(message);

    }

    public List<Message> conversation(
            String user1,
            String user2) {

        List<Message> chat = new ArrayList<>();

        chat.addAll(repository.findBySenderEmailAndReceiverEmailOrderBySentAtAsc(user1, user2));

        chat.addAll(repository.findByReceiverEmailAndSenderEmailOrderBySentAtAsc(user1, user2));

        chat.sort(Comparator.comparing(Message::getSentAt));

        return chat;

    }

}