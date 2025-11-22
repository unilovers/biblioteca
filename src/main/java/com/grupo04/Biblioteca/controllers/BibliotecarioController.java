package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {
    @Autowired
    public BibliotecarioRepository repository;
}
