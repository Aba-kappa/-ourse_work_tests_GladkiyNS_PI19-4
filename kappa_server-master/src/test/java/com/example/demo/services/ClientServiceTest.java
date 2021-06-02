package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repos.ClientRepo;
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
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepo clientRepo;

    @Test
    public void getAllClients() {
        List<Client> response = new ArrayList<>();

        Client client = new Client();
        response.add(client);

        Mockito.when(clientService.getAllClients()).thenReturn(response);
        Assert.assertEquals(clientService.getAllClients(), response);
    }

    @Test
    public void saveClient() {
        Client client = new Client();
        boolean isCreated = clientService.saveClient(client);

        Assert.assertTrue(isCreated);

    }

    @Test
    public void updateClient() {
        Client client = new Client();
        client.setClientId(1);

        Optional<Client> optional = Optional.of(client);

        Mockito.doReturn(optional)
                .when(clientRepo)
                .findById(1);

        boolean isUpdated = clientService.updateClient(client, client.getClientId());
        Assert.assertTrue(isUpdated);
    }

    @Test
    public void deleteClient() {
        Client client = new Client();
        client.setClientId(1);

        Optional<Client> optional = Optional.of(client);

        Mockito.doReturn(optional)
                .when(clientRepo)
                .findById(1);

        boolean isDeleted = clientService.deleteClient(1);
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void signupClient() {
        Client client = new Client();
        client.setEmail("test@gmail.com");

        Mockito.doReturn(null)
                .when(clientRepo)
                .getByEmail("test@gmail.com");

        Mockito.doReturn(client)
                .when(clientRepo)
                .save(client);

        Client signed = clientService.signupClient(client);
        Assert.assertEquals(client, signed);
    }

    @Test
    public void signinClient() {
        Client client = new Client();
        client.setEmail("test@gmail.com");
        client.setPassword("123321");

        Mockito.doReturn(client)
                .when(clientRepo)
                .getByEmail("test@gmail.com");

        Client signed = clientService.signinClient(client);
        Assert.assertEquals(client, signed);
    }
}