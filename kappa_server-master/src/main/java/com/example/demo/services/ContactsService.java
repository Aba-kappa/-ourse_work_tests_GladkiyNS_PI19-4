package com.example.demo.services;

import com.example.demo.entities.Contacts;
import com.example.demo.repos.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис для класса {@link Contacts}
 */
@Service
public class ContactsService {

    private ContactsRepo contactsRepo;

    @Autowired
    public ContactsService(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

    /**
     * Получение контактных данных барбершопа
     * @return контактные данные
     */
    public Optional<Contacts> getContacts() {
        return contactsRepo.findById(1);
    }

}
