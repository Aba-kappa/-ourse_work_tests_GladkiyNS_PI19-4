package com.example.demo.services;

import com.example.demo.entities.Barber;
import com.example.demo.repos.BarberRepo;
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
public class BarberServiceTest {

    @Autowired
    private BarberService barberService;

    @MockBean
    private BarberRepo barberRepo;

    @Test
    public void getAllEmployees() {
        List<Barber> response = new ArrayList<>();

        Barber barber = new Barber();
        response.add(barber);

        Mockito.when(barberService.getAllEmployees()).thenReturn(response);
        Assert.assertEquals(barberService.getAllEmployees(), response);
    }

    @Test
    public void updateEmployee() {
        Barber barber = new Barber();
        barber.setEmployeeId(1);

        Optional<Barber> optional = Optional.of(barber);

        Mockito.doReturn(optional)
                .when(barberRepo)
                .findById(1);

        boolean isUpdated = barberService.updateEmployee(barber, barber.getEmployeeId());
        Assert.assertTrue(isUpdated);
    }

    @Test
    public void saveEmployee() {
        Barber barber = new Barber();
        boolean isCreated = barberService.saveEmployee(barber);

        Assert.assertTrue(isCreated);
    }

    @Test
    public void deleteEmployee() {
        Barber barber = new Barber();
        barber.setEmployeeId(1);

        Optional<Barber> optional = Optional.of(barber);

        Mockito.doReturn(optional)
                .when(barberRepo)
                .findById(1);

        boolean isDeleted = barberService.deleteEmployee(1);
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void signupBarber() {
        Barber barber = new Barber();
        barber.setEmail("test@gmail.com");

        Mockito.doReturn(null)
                .when(barberRepo)
                .getByEmail("test@gmail.com");

        boolean isSigned = barberService.signupBarber(barber);
        Assert.assertTrue(isSigned);
    }

    @Test
    public void signinBarber() {
        Barber barber = new Barber();
        barber.setEmail("test@gmail.com");
        barber.setPassword("123321");

        Mockito.doReturn(barber)
                .when(barberRepo)
                .getByEmail("test@gmail.com");

        Barber signed = barberService.signinBarber(barber);
        Assert.assertEquals(barber, signed);
    }
}