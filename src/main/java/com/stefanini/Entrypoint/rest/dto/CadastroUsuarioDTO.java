package com.stefanini.Entrypoint.rest.dto;

import lombok.Getter;


@Getter
public class CadastroUsuarioDTO {

    private String nome;
    private String login;
    private String email;
    private String senha;
    private String dataDeNascimento;
}
