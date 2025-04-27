package com.doit.isee.service;

import com.doit.isee.model.Client;
import com.doit.isee.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // Search logic
    public List<Client> searchClients(String name, String email) {
        if (name != null && email != null) {
            return clientRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(name, email);
        } else if (name != null) {
            return clientRepository.findByNameContainingIgnoreCase(name);
        } else if (email != null) {
            return clientRepository.findByEmailContainingIgnoreCase(email);
        } else {
            return clientRepository.findAll();  // Return all clients if no search criteria
        }
    }
}
