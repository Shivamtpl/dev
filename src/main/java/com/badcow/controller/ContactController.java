package com.badcow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.badcow.entity.Contact;
import com.badcow.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact save(
            @RequestBody Contact contact) {

        return contactService.save(contact);
    }

    @GetMapping
    public List<Contact> getAll() {

        return contactService.getAll();
    }
}