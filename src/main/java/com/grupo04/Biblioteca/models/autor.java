package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_autor")
    private Integer id;

    @Column(name = "nm_autor", nullable = false, length = 50)
    private String nome;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "sn_ativo", nullable = false, length = 1)
    private String ativo;

 public Autor() {}

     public Autor(String nome, LocalDateTime dataCadastro, String ativo) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

 public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
