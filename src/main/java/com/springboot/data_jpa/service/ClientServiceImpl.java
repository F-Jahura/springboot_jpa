package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Client;
import com.springboot.data_jpa.repository.ClientRepository;
import com.springboot.data_jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        long countPersonList = clientRepository.findAll().stream().count();
        System.out.println("Client in the list: " + countPersonList);
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(int id) {
        Client client = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()){
            client = optional.get();

        }
        else System.out.println("ID is not found.");
        return client;
    }

    /*@Override
    public long countClient() {
       long countList = clientRepository.count();
        return countList;
    }

    @Override
    public void countClientList() {
        long countList = clientRepository.count();
        System.out.println("Client int the list: " + countList);
    }*/

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
