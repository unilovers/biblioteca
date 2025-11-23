package com.grupo04.Biblioteca.repository;

import com.grupo04.Biblioteca.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
