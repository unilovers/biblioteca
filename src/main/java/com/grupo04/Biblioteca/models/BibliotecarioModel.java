package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bibliotecario")
public class BibliotecarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_bibliotecario")
    private Long cd_bibliotecario;

    @Column(name = "nm_bibliotecario")
    private String nm_bibliotecario;

    @Column(name = "cd_senha")
    private String cd_senha;

    @Column(name = "dt_nascimento")
    private LocalDateTime dt_nascimento;

    @Column(name = "tp_sexo")
    private char tp_sexo;

    @Column(name = "ds_email")
    private String ds_email;

    @Column(name = "dt_cadastro")
    private LocalDateTime dt_cadastro;

    @Column(name = "sn_ativo")
    private char sn_ativo;
}
