package com.example.demo.repos;

import com.example.demo.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Интерфейс для класса {@link Contract}
 */
public interface ContractRepo extends JpaRepository<Contract, Integer> {

    /**
     * Запрос для получения записей на услугу по ID услуги с сортировкой по времени записи
     * @param id ID услуги
     * @return записи на выбранную услугу
     */
    @Query(nativeQuery = true, value = "select * from Contract where CLIENTS_client_id is null and SERVICES_service_id = :service_id ORDER BY date_time")
    List<Contract> getFreeContractsByServiceId(@Param("service_id") Integer id);

    /**
     * Запрос для получения записей на услуги по ID барбера с сортировкой по времени записи
     * @param id ID барбера
     * @return записи к выбранному барберу
     */
    @Query(nativeQuery = true, value = "select * from Contract where CLIENTS_client_id is null and EMPLOYEES_employee_id = :barber_id ORDER BY date_time")
    List<Contract> getFreeContractsByBarberId(@Param("barber_id") Integer id);

    /**
     * Запрос для получения записи на услугу по ID клиента
     * @param id ID клиента
     * @return запись конкретного клиента
     */
    @Query(nativeQuery = true, value = "select * from Contract where CLIENTS_client_id = :client_id ORDER BY date_time DESC LIMIT 1")
    Contract getLastSign(@Param("client_id") Integer id);

}
