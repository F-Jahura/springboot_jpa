package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public void saveClient(Client client);

    public Client getClient(int id);

    public void deleteClient(int id);
}
