package com.grupo04.Biblioteca.repository;


import com.grupo04.Biblioteca.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
