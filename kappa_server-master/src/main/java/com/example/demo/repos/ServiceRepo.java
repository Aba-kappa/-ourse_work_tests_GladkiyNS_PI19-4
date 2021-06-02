package com.example.demo.repos;

import com.example.demo.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для класса {@link Service}
 */
public interface ServiceRepo extends JpaRepository<Service, Integer> {

}
