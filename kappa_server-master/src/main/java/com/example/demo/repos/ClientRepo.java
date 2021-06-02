package com.example.demo.repos;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Интерфейс для класса {@link Client}
 */
public interface ClientRepo extends JpaRepository<Client, Integer> {

    /**
     * Запрос для получения клиента по его эл. почте
     * @param email эл. почта
     * @return клиента с заданной эл. почтой
     */
    @Query(nativeQuery = true, value = "select * from Client where email = :email")
    Client getByEmail(@Param("email") String email);

}
