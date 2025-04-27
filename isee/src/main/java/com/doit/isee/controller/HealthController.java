package com.doit.isee.controller;

import com.doit.isee.model.Client;
import com.doit.isee.model.Program;
import com.doit.isee.service.ClientService;
import com.doit.isee.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000, **")
public class HealthController {
    @Autowired
    private HealthService healthService;
    private ClientService clientService;

    @PostMapping("/clients")
    public Client registerClient(@RequestBody Client client) {
        return healthService.registerClient(client);
    }

    @PostMapping("/programs")
    public Program createProgram(@RequestBody Program program) {
        return healthService.createProgram(program);
    }

    @PostMapping("/clients/{clientId}/enroll/{programId}")
    public String enrollClient(@PathVariable Long clientId, @PathVariable Long programId) {
        healthService.enrollClientToProgram(clientId, programId);
        return "Client enrolled to program successfully!";
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return healthService.getAllClients();
    }

    @GetMapping("/clients/{clientId}")
    public Optional<Client> getClientProfile(@PathVariable Long clientId) {
        return healthService.getClientProfile(clientId);
    }
    @GetMapping("/search")
    public List<Client> searchClients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return clientService.searchClients(name, email);
    }
}
