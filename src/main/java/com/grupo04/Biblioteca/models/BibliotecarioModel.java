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
    private Long cdBibliotecario;

    @Column(name = "nm_bibliotecario")
    private String nmBibliotecario;

    @Column(name = "cd_senha")
    private String cdSenha;

    @Column(name = "dt_nascimento")
    private LocalDateTime dtNascimento;

    @Column(name = "tp_sexo")
    private char tpSexo;

    @Column(name = "ds_email")
    private String dsEmail;

    @Column(name = "dt_cadastro")
    private LocalDateTime dtCadastro;

    @Column(name = "sn_ativo")
    private char snAtivo;
}
