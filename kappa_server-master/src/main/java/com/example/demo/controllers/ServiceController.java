package com.example.demo.controllers;

import com.example.demo.entities.Service;
import com.example.demo.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для класса {@link Service}
 */
@RestController
public class ServiceController {

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    /**
     * Получение списка всех услуг
     * @return "ОК", если в списке имеется хотя бы одна услуга или "NOT_FOUND", если список пуст
     */
    @GetMapping("services/get")
    public ResponseEntity<List<Service>> getServices() {
        List<Service> services = serviceService.getAllServices();

        if (services == null || services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(services, HttpStatus.OK);
        }
    }

    /**
     * Сохранение информации об услуге
     * @param service услуга
     */
    @PostMapping("services/post")
    public void postService(@RequestBody Service service) {
        serviceService.saveService(service);
    }

    /**
     * Обновление информации об услуги по её ID
     * @param serviceId ID услуги
     * @param service услуга
     * @return "OK", если информация об услуге была обновлена или "NOT_FOUND", если услуги с данным ID не существует
     */
    @PutMapping("services/put/{serviceId}")
    public ResponseEntity<?> updateService(@PathVariable("serviceId") Integer serviceId, @RequestBody Service service) {
        if (serviceService.updateService(service, serviceId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Удаление услуги по её ID
     * @param serviceId ID услуги
     * @return "ОК", если удаление из списка прошло успешно или "NOT_FOUND", если услуги с данным ID не существует
     */
    @DeleteMapping("services/delete/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable("serviceId") Integer serviceId) {
        if (serviceService.deleteService(serviceId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
