package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Client}
 */
@Service
public class ClientService {

    private ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    /**
     * Получение списка всех клиентов
     *
     * @return список клиентов
     */
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    /**
     * Сохранение информации о клиенте
     *
     * @param client клиент
     */
    public boolean saveClient(Client client) {
        clientRepo.save(client);
        return true;
    }

    /**
     * Обновление информации о клиенте по его ID
     *
     * @param clientId ID клиента
     * @param client   клиент
     * @return "true", если информация о клиенте была обновлена или "false", если клиента с данным ID не существует
     */
    public boolean updateClient(Client client, Integer clientId) {
        if (getClientById(clientId).isPresent()) {
            client.setClientId(clientId);
            clientRepo.save(client);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Удаление клиента по его ID
     *
     * @param clientId ID клиента
     * @return "true", если удаление из списка прошло успешно или "false", если клиента с данным ID не существует
     */
    public boolean deleteClient(Integer clientId) {
        if (getClientById(clientId).isPresent()) {
            clientRepo.deleteById(clientId);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Получение клиента по его ID
     *
     * @param clientId ID клиента
     * @return клиента по заданному ID
     */
    private Optional<Client> getClientById(Integer clientId) {
        return clientRepo.findById(clientId);
    }

    /**
     * Регистрация клиента в приложении
     *
     * @param client клиент
     * @return успешную регистрацию, иначе "null"
     */
    public Client signupClient(Client client) {
        if (clientRepo.getByEmail(client.getEmail()) == null) {
            return clientRepo.save(client);

        } else {
            return null;
        }
    }

    /**
     * Авторизация клиента в приложении
     *
     * @param client клиент
     * @return "client1", если авторизация прошла успешно, иначе "null"
     */
    public Client signinClient(Client client) {
        Client client1 = clientRepo.getByEmail(client.getEmail());
        if (client1 != null) {
            if (client.getPassword().equals(client1.getPassword()))
                return client1;

            else return null;
        }
        return null;
    }
}
