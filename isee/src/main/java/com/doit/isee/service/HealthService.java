package com.doit.isee.service;

import com.doit.isee.model.Client;
import com.doit.isee.model.Program;
import com.doit.isee.repository.ClientRepository;
import com.doit.isee.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProgramRepository programRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public void enrollClientToProgram(Long clientId, Long programId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Program program = programRepository.findById(programId).orElseThrow(() -> new RuntimeException("Program not found"));
        client.getPrograms().add(program);
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientProfile(Long clientId) {
        return clientRepository.findById(clientId);
    }
}
