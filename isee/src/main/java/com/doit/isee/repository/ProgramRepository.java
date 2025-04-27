package com.doit.isee.repository;

import com.doit.isee.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
