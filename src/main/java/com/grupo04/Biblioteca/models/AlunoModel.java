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
@Table (name = "alunos")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cd_aluno")
    private Long cd_aluno;

    @Column (name = "nm_aluno")
    private String nm_aluno;

    @Column (name = "dt_nascimento")
    private LocalDateTime dt_nascimento;

    @Column (name = "tp_sexo")
    private char tp_sexo;

    @Column (name = "ds_email")
    private String ds_email;

    @Column (name = "dt_cadastro")
    private LocalDateTime dt_cadastro;

    @Column (name = "sn_ativo")
    private char sn_ativo;


}