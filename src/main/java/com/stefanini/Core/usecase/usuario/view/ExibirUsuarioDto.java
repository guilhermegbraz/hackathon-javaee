package com.stefanini.Core.usecase.usuario.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ExibirUsuarioDto {
    private String nome;
    private String login;
    private String email;
    private LocalDate dataDeNascimento;
}
