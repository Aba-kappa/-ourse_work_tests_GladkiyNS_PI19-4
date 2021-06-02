package com.example.demo.services;

import com.example.demo.entities.Service;
import com.example.demo.repos.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Service}
 */
@org.springframework.stereotype.Service
public class ServiceService {

    private ServiceRepo serviceRepo;

    @Autowired
    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    /**
     * Получение списка всех услуг
     * @return список услуг
     */
    public List<Service> getAllServices() {
        return serviceRepo.findAll();
    }

    /**
     * Сохранение информации об услуге
     * @param service услуга
     */
    public boolean saveService(Service service) {
        serviceRepo.save(service);
        return true;
    }

    /**
     * Обновление информации об услуги по её ID
     * @param serviceId ID услуги
     * @param service услуга
     * @return "true", если информация об услуге была обновлена или "false", если услуги с данным ID не существует
     */
    public boolean updateService(Service service, Integer serviceId) {
        if (getServiceById(serviceId).isPresent()) {
            service.setServiceId(serviceId);
            serviceRepo.save(service);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Удаление услуги по её ID
     * @param serviceId услуги
     * @return "true", если удаление из списка прошло успешно или "false", если услуги с данным ID не существует
     */
    public boolean deleteService(Integer serviceId) {
        if (getServiceById(serviceId).isPresent()) {
            serviceRepo.deleteById(serviceId);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Получение услуги по её ID
     * @param serviceId ID услуги
     * @return услуги по заданному ID
     */
    private Optional<Service> getServiceById(Integer serviceId) {
        return serviceRepo.findById(serviceId);
    }

}
