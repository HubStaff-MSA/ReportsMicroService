package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {

    private final List<Client> clients = new ArrayList<>();

    public ClientRepository() {

        clients.add(new Client(1, "Client A", "clientA@mail.com", "1234567890", "111 Main St"));
        clients.add(new Client(2, "Client B", "clientB@mail.com", "1234567890", "222 Main St"));
        clients.add(new Client(3, "Client C", "clientC@mail.com", "1234567890", "333 Main St"));

    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(Integer clientId) {
        return clients.stream()
                .filter(client -> client.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }
}
