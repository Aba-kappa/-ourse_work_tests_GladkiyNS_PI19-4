package com.example.demo.services;

import com.example.demo.entities.Service;
import com.example.demo.repos.ServiceRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceServiceTest {

    @Autowired
    private ServiceService serviceService;

    @MockBean
    private ServiceRepo serviceRepo;

    @Test
    public void getAllServices() {
        List<Service> response = new ArrayList<>();

        Service service = new Service();
        response.add(service);

        Mockito.when(serviceService.getAllServices()).thenReturn(response);
        Assert.assertEquals(serviceService.getAllServices(), response);
    }

    @Test
    public void saveService() {
        Service service = new Service();
        boolean isCreated = serviceService.saveService(service);

        Assert.assertTrue(isCreated);
    }

    @Test
    public void updateService() {
        Service service = new Service();
        service.setServiceId(1);

        Optional<Service> optional = Optional.of(service);

        Mockito.doReturn(optional)
                .when(serviceRepo)
                .findById(1);

        boolean isUpdated = serviceService.updateService(service, service.getServiceId());
        Assert.assertTrue(isUpdated);
    }

    @Test
    public void deleteService() {
        Service service = new Service();
        service.setServiceId(1);

        Optional<Service> optional = Optional.of(service);

        Mockito.doReturn(optional)
                .when(serviceRepo)
                .findById(1);

        boolean isDeleted = serviceService.deleteService(1);
        Assert.assertTrue(isDeleted);
    }
}