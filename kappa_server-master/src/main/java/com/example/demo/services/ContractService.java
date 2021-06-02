package com.example.demo.services;

import com.example.demo.entities.Contract;
import com.example.demo.repos.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Contract}
 */
@Service
public class ContractService {

    private ContractRepo contractRepo;

    @Autowired
    public ContractService(ContractRepo contractRepo) {
        this.contractRepo = contractRepo;
    }

    /**
     * Получение списка всех записей на услуги
     * @return список записей
     */
    public List<Contract> getAllContracts() {
        return contractRepo.findAll();
    }

    /**
     * Получение записей на услугу по ID услуги
     * @param id ID услуги
     * @return записи на выбранную услугу
     */
    public List<Contract> getFreeContractsByServiceId(Integer id) {
        return contractRepo.getFreeContractsByServiceId(id);
    }

    /**
     * Получение записей на услуги по ID барбера
     * @param id ID барбера
     * @return записи к выбранному барберу
     */
    public List<Contract> getFreeContractsByBarberId(Integer id) {
        return contractRepo.getFreeContractsByBarberId(id);
    }

    /**
     * Сохранение информации о записи на услугу
     * @param contract запись
     */
    public boolean saveContract(Contract contract) {
        contractRepo.save(contract);
        return true;
    }

    /**
     * Обновление информации о записи на услугу по её ID
     * @param contractId ID записи
     * @param contract запись
     * @return "true", если информация о записи была обновлена или "false", если записи с данным ID не существует
     */
    public boolean updateContract(Contract contract, Integer contractId) {
        if (getClientById(contractId).isPresent()) {
            contract.setContractId(contractId);
            contractRepo.save(contract);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Удаление записи по её ID
     * @param contractId ID записи
     * @return "true", если удаление из списка прошло успешно или "false", если записи с данным ID не существует
     */
    public boolean deleteContract(Integer contractId) {
        if (getClientById(contractId).isPresent()) {
            contractRepo.deleteById(contractId);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Получение записи на услугу по её ID
     * @param contractId ID записи
     * @return выбранную запись
     */
    private Optional<Contract> getClientById(Integer contractId) {
        return contractRepo.findById(contractId);
    }

    /**
     * Получение записи на услугу по ID клиента
     * @param clientId ID клиента
     * @return запись конкретного клиента
     */
    public Contract getLastSign(Integer clientId) {
        return contractRepo.getLastSign(clientId);
    }
}
