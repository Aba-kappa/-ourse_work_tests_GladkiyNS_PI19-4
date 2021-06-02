package com.example.demo.repos;

import com.example.demo.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для класса {@link Contacts}
 */
public interface ContactsRepo extends JpaRepository<Contacts, Integer> {
}
