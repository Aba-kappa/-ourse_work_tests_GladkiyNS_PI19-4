package com.example.demo.services;

import com.example.demo.entities.Barber;
import com.example.demo.entities.Contract;
import com.example.demo.entities.Service;
import com.example.demo.repos.ContractRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @MockBean
    private ContractRepo contractRepo;

    @Test
    public void getAllContracts() {
        List<Contract> response = new ArrayList<>();

        Contract contract = new Contract();
        response.add(contract);

        Mockito.when(contractService.getAllContracts()).thenReturn(response);
        Assert.assertEquals(contractService.getAllContracts(), response);
    }

    @Test
    public void getFreeContractsByServiceId() {
        List<Contract> response = new ArrayList<>();

        Contract contract = new Contract();

        Service service = new Service();
        service.setServiceId(1);

        contract.setService(service);
        response.add(contract);

        Mockito.doReturn(response)
                .when(contractRepo)
                .getFreeContractsByServiceId(1);

        Assert.assertEquals(contractService.getFreeContractsByServiceId(1), response);
    }

    @Test
    public void getFreeContractsByBarberId() {
        List<Contract> response = new ArrayList<>();

        Contract contract = new Contract();

        Barber barber = new Barber();
        barber.setEmployeeId(1);

        contract.setBarber(barber);
        response.add(contract);

        Mockito.doReturn(response)
                .when(contractRepo)
                .getFreeContractsByBarberId(1);

        Assert.assertEquals(contractService.getFreeContractsByBarberId(1), response);
    }

    @Test
    public void saveContract() {
       Contract contract = new Contract();
        boolean isCreated = contractService.saveContract(contract);

        Assert.assertTrue(isCreated);
    }

    @Test
    public void updateContract() {
        Contract contract = new Contract();
        contract.setContractId(1);

        Optional<Contract> optional = Optional.of(contract);

        Mockito.doReturn(optional)
                .when(contractRepo)
                .findById(1);

        boolean isUpdated = contractService.updateContract(contract, contract.getContractId());
        Assert.assertTrue(isUpdated);
    }

    @Test
    public void deleteContract() {
        Contract contract = new Contract();
        contract.setContractId(1);

        Optional<Contract> optional = Optional.of(contract);

        Mockito.doReturn(optional)
                .when(contractRepo)
                .findById(1);

        boolean isDeleted = contractService.deleteContract(1);
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void getLastSign() {
        Contract lastContract = new Contract();

        Mockito.doReturn(lastContract)
                .when(contractRepo)
                .getLastSign(1);

        Assert.assertEquals(contractService.getLastSign(1), lastContract);
    }
}