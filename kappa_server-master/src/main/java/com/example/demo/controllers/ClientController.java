package com.example.demo.controllers;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для класса {@link Client}
 */
@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Получение списка всех клиентов
     * @return "ОК", если в списке имеется хотя бы один клиент или "NOT_FOUND", если список пуст
     */
    @GetMapping("clients/get")
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.getAllClients();

        if (clients == null || clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
    }

    /**
     * Сохранение информации о клиенте
     * @param client клиент
     */
    @PostMapping("clients/post")
    public void postClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    /**
     * Обновление информации о клиенте по его ID
     * @param clientId ID клиента
     * @param client клиент
     * @return "OK", если информация о клиенте была обновлена или "NOT_FOUND", если клиента с данным ID не существует
     */
    @PutMapping("clients/put/{clientId}")
    public ResponseEntity<?> updateClient(@PathVariable("clientId") Integer clientId, @RequestBody Client client) {
        if (clientService.updateClient(client, clientId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Удаление клиента по его ID
     * @param clientId ID клиента
     * @return "ОК", если удаление из списка прошло успешно или "NOT_FOUND", если клиента с данным ID не существует
     */
    @DeleteMapping("clients/delete/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable("clientId") Integer clientId) {
        if (clientService.deleteClient(clientId)) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Регистрация клиента в приложении
     * @param client клиент
     * @return "ОК", если регистрация прошла успешно, иначе "BAD_REQUEST"
     */
    @PostMapping("clients/signup")
    public ResponseEntity<Client> signupClient(@RequestBody Client client) {
        Client client1 = clientService.signupClient(client);
        if (client1 != null) {
            return new ResponseEntity<>(client1, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Авторизация клиента в приложении
     * @param client клиент
     * @return "ОК", если авторизация прошла успешно, иначе "NOT_FOUND"
     */
    @PostMapping("clients/signin")
    public ResponseEntity<Client> signinClient(@RequestBody Client client) {
        Client client1 = clientService.signinClient(client);

        if (client1 != null) {
            return new ResponseEntity<>(client1, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
