package com.grupo04.Biblioteca.repository;

import com.grupo04.Biblioteca.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> { }
