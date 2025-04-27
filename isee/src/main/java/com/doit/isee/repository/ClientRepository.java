package com.doit.isee.repository;

import com.doit.isee.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Find clients by name (case insensitive)
    List<Client> findByNameContainingIgnoreCase(String name);

    // Find clients by email (case insensitive)
    List<Client> findByEmailContainingIgnoreCase(String email);

    // Find clients by either name or email (case insensitive)
    List<Client> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
}
