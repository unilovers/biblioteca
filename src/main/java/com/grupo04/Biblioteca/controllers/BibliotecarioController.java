package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.dto.BibliotecarioDTO;
import com.grupo04.Biblioteca.models.BibliotecarioModel;
import com.grupo04.Biblioteca.repository.BibliotecarioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bibliotecarios")
@Tag(name = "Bibliotecario")
public class BibliotecarioController {
    @Autowired
    public BibliotecarioRepository repository;

    @GetMapping
    public ResponseEntity<List<BibliotecarioDTO>> findAll() {
        List<BibliotecarioModel> list = repository.findAll();
        List<BibliotecarioDTO>  listDTO = new ArrayList<>();

        list.forEach(bibliotecarioModel -> {
            listDTO.add(new BibliotecarioDTO(bibliotecarioModel.getCdBibliotecario(),
                                            bibliotecarioModel.getNmBibliotecario(),
                                            bibliotecarioModel.getDtNascimento(),
                                            bibliotecarioModel.getTpSexo()));
        });
        return ResponseEntity.ok(listDTO);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BibliotecarioModel novoBiblitoecario) {
        try{
            repository.save(novoBiblitoecario);
            return  ResponseEntity.status(HttpStatus.CREATED).body(novoBiblitoecario);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
