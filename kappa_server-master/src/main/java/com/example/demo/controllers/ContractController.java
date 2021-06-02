package com.example.demo.controllers;

import com.example.demo.entities.Contract;
import com.example.demo.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для класса {@link Contract}
 */
@RestController
public class ContractController {

    private ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * Получение списка всех записей на услуги
     * @return "ОК", если в списке имеется хотя бы одна запись или "NOT_FOUND", если список пуст
     */
    @GetMapping("contracts/get")
    public ResponseEntity<List<Contract>> getContracts() {
        List<Contract> contracts = contractService.getAllContracts();

        if (contracts == null || contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    /**
     * Получение последней записи на услугу по её ID
     * @param id ID записи
     * @return "OK", если запись была найдена, иначе "NOT_FOUND"
     */
    @GetMapping("contracts/get/last/{id}")
    public ResponseEntity<Contract> getLastContract(@PathVariable("id") Integer id) {
        Contract contract = contractService.getLastSign(id);

        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contract, HttpStatus.OK);
        }
    }

    /**
     * Получение записи на услугу по ID услуги
     * @param id ID услуги
     * @return "OK", если запись была найдена или "NOT_FOUND", если записей с данной услугой не существует
     */
    @GetMapping("contracts/get/service/{id}")
    public ResponseEntity<List<Contract>> getFreeContractsByServiceId(@PathVariable("id") Integer id) {
        List<Contract> contracts = contractService.getFreeContractsByServiceId(id);

        if (contracts == null || contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    /**
     * Получение записи на услугу по ID барбера
     * @param id ID барбера
     * @return "OK", если запись была найдена или "NOT_FOUND", если записей с данным барбером не существует
     */
    @GetMapping("contracts/get/barber/{id}")
    public ResponseEntity<List<Contract>> getFreeContractsByBarberId(@PathVariable("id") Integer id) {
        List<Contract> contracts = contractService.getFreeContractsByBarberId(id);

        if (contracts == null || contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    /**
     * Сохранение информации о записи на услугу
     * @param contract запись
     */
    @PostMapping("contracts/post")
    public void postContract(@RequestBody Contract contract) {
        contractService.saveContract(contract);
    }

    /**
     * Обновление информации о записи на услугу по её ID
     * @param contractId ID записи
     * @param contract запись
     * @return "OK", если информация о записи была обновлена или "NOT_FOUND", если записи с данным ID не существует
     */
    @PutMapping("contracts/put/{contractId}")
    public ResponseEntity<?> updateContract(@PathVariable("contractId") Integer contractId, @RequestBody Contract contract) {
        if (contractService.updateContract(contract, contractId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Удаление записи на услугу по её ID
     * @param contractId ID записи
     * @return "ОК", если удаление из списка прошло успешно или "NOT_FOUND", если записи с данным ID не существует
     */
    @DeleteMapping("contracts/delete/{contractId}")
    public ResponseEntity<?> deleteContract(@PathVariable("contractId") Integer contractId) {
        if (contractService.deleteContract(contractId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
