package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")

public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_livro")
    private Long cd_livro;

    @Column(name = "nm_livro")
    private String nm_livro;

    @Column(name = "cd_bibliotecario")
    private Long cd_bibliotecario;

    @Column(name = "cd_categoria")
    private Long cd_categoria;

    @Column(name = "cd_autor")
    private Long cd_autor;

    @Column(name = "cd_aluno")
    private Long cd_aluno;

    @Column(name = "cd_professor")
    private Long cd_professor;

    @Column(name = "sn_locado")
    private char sn_locado;

    @Column(name = "dt_cadastro")
    private Timestamp dt_cadastro;

    @Column(name = "sn_ativo")
    private char sn_ativo;

}
