package com.example.fleet_app_version2.parameters.services;

import com.example.fleet_app_version2.parameters.models.Client;
import com.example.fleet_app_version2.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public void saveClient(Client client){
        clientRepository.save(client);
    }
    public void deleteClient(Integer id){
       clientRepository.deleteById(id);
    }
    public Client getByClientById(Integer id){
       return clientRepository.findById(id).orElse(null);
    }

}
