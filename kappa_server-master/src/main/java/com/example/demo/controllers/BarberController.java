package com.example.demo.controllers;

import com.example.demo.entities.Barber;
import com.example.demo.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для класса {@link Barber}
 */
@RestController
public class BarberController {

    private BarberService barberService;

    @Autowired
    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    /**
     * Получение списка всех барберов
     * @return "ОК", если в списке имеется хотя бы один барбер или "NOT_FOUND", если список пуст
     */
    @GetMapping("employees/get")
    public ResponseEntity<List<Barber>> getEmployees() {
        List<Barber> barbers = barberService.getAllEmployees();

        if (barbers == null || barbers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(barbers, HttpStatus.OK);
        }
    }

    /**
     * Сохранение информации о барбере
     * @param barber барбер
     */
    @PostMapping("employees/post")
    public void postEmployee(@RequestBody Barber barber) {
        barberService.saveEmployee(barber);
    }

    /**
     * Обновление информации о барбере по его ID
     * @param employeeId ID барбера
     * @param barber барбер
     * @return "OK", если информация о барбере была обновлена или "NOT_FOUND", если барбера с данным ID не существует
     */
    @PutMapping("employees/put/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Barber barber) {
        if (barberService.updateEmployee(barber, employeeId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Удаление барбера по его ID
     * @param employeeId ID барбера
     * @return "ОК", если удаление из списка прошло успешно или "NOT_FOUND", если барбера с данным ID не существует
     */
    @DeleteMapping("employees/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        if (barberService.deleteEmployee(employeeId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Регистрация барбера в приложении
     * @param barber барбер
     * @return "ОК", если регистрация прошла успешно, иначе "BAD_REQUEST"
     */
    @PostMapping("employees/signup")
    public ResponseEntity<Barber> signupBarber(@RequestBody Barber barber) {
        if (barberService.signupBarber(barber)) {
            return new ResponseEntity<>(barber, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Авторизация барбера в приложении
     * @param barber барбер
     * @return "ОК", если авторизация прошла успешно, иначе "NOT_FOUND"
     */
    @PostMapping("employees/signin")
    public ResponseEntity<Barber> signinBarber(@RequestBody Barber barber) {
        Barber barber1 = barberService.signinBarber(barber);

        if (barber1 != null) {
            return new ResponseEntity<>(barber, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
