package com.grupo04.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo04.Biblioteca.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
