package com.stefanini.Entrypoint.rest.dto;

import com.stefanini.Core.exceptions.BusinessException;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AtualizarUsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private String dataDeNascimento;

    public LocalDate getDataDeNascimento() {
        try{
        return this.dataDeNascimento == null? null: LocalDate.parse(this.dataDeNascimento);
        }catch (Exception e){
            throw new BusinessException("Formato de data invalido");
        }
    }
}
