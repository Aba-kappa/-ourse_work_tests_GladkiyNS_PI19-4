package com.example.demo.services;

import com.example.demo.entities.Barber;
import com.example.demo.repos.BarberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Barber}
 */
@Service
public class BarberService {

    private BarberRepo barberRepo;

    @Autowired
    public BarberService(BarberRepo barberRepo) {
        this.barberRepo = barberRepo;
    }

    /**
     * Получение списка всех барберов
     *
     * @return список барберов
     */
    public List<Barber> getAllEmployees() {
        return barberRepo.findAll();
    }

    /**
     * Сохранение информации о барбере
     *
     * @param barber барбер
     */
    public boolean saveEmployee(Barber barber) {
        try {
            barberRepo.save(barber);
            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Обновление информации о барбере по его ID
     *
     * @param employeeId ID барбера
     * @param barber     барбер
     * @return "true", если информация о барбере была обновлена или "false", если барбера с данным ID не существует
     */
    public boolean updateEmployee(Barber barber, Integer employeeId) {
        if (getEmployeeById(employeeId).isPresent()) {
            barber.setEmployeeId(employeeId);
            barberRepo.save(barber);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Удаление барбера по его ID
     *
     * @param employeeId ID барбера
     * @return "true", если удаление из списка прошло успешно или "false", если барбера с данным ID не существует
     */
    public boolean deleteEmployee(Integer employeeId) {
        if (getEmployeeById(employeeId).isPresent()) {
            barberRepo.deleteById(employeeId);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Получение барбера по его ID
     *
     * @param employeeId ID барбера
     * @return барбера по заданному ID
     */
    public Optional<Barber> getEmployeeById(Integer employeeId) {
        return barberRepo.findById(employeeId);
    }

    /**
     * Регистрация барбера в приложении
     *
     * @param barber барбер
     * @return "true", если регистрация прошла успешно, иначе "false"
     */
    public boolean signupBarber(Barber barber) {
        if (barberRepo.getByEmail(barber.getEmail()) == null) {
            barberRepo.save(barber);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Авторизация барбера в приложении
     *
     * @param barber барбер
     * @return "barber1", если авторизация прошла успешно, иначе "null"
     */
    public Barber signinBarber(Barber barber) {
        Barber barber1 = barberRepo.getByEmail(barber.getEmail());
        if (barber1 != null) {
            if (barber.getPassword().equals(barber1.getPassword()))
                return barber1;

            else return null;
        }
        return null;
    }

}
