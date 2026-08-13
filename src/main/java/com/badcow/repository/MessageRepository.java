package com.badcow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcow.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderEmailAndReceiverEmailOrderBySentAtAsc(
            String sender,
            String receiver);

    List<Message> findByReceiverEmailAndSenderEmailOrderBySentAtAsc(
            String receiver,
            String sender);
}