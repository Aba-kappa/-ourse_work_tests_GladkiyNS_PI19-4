package com.example.demo.repos;

import com.example.demo.entities.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Интерфейс для класса {@link Barber}
 */
public interface BarberRepo extends JpaRepository<Barber, Integer> {

    /**
     * Запрос для получения барбера по его эл. почте
     * @param email эл. почта
     * @return барбера с заданной эл. почтой
     */
    @Query(nativeQuery = true, value = "select * from Barber where email = :email")
    Barber getByEmail(@Param("email") String email);

}
