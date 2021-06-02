package com.example.demo.controllers;

import com.example.demo.entities.Contacts;
import com.example.demo.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Контроллер для класса {@link Contacts}
 */
@RestController
public class ContactsController {

    private ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    /**
     * Получение контактных данных барбершопа
     * @return "ОК", если сущность содержит контактные данные, иначе "NOT_FOUND"
     */
    @GetMapping(value = "contacts/get")
    private ResponseEntity<Optional<Contacts>> getContacts() {
        Optional<Contacts> contacts = contactsService.getContacts();

        if (contacts.isPresent()) {
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
