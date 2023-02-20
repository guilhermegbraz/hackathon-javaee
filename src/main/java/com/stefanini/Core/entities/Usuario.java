package com.stefanini.Core.entities;

import lombok.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = {"id", "login"})
public class Usuario {
    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private LocalDate dataDeNascimento;

    public Usuario(String nome, String login, String email, String senha, String dataDeNascimento) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        if(dataDeNascimento != null) {
            this.dataDeNascimento = LocalDate.parse(dataDeNascimento);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }



}
