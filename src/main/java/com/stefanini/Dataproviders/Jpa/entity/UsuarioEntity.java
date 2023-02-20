package com.stefanini.Dataproviders.Jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "usuario")
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Length(max =50, message = "O atributo nome não deve exceder 50 caracteres")
    @NotBlank(message = "O atributo nome não pode estar em branco")
    private String nome;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max = 20, message = "O atributo Login deve possuir entre 5 e 20 caracteres")
    @NotBlank(message = "O atributo login não pode estar em branco")
    private String login;

    @Column(nullable = false)
    @Email(message = "Email invalido")
    @Length(min = 10, message = "O Atributo e-mail deve possuir no minimo 10 caracteres")
    @NotBlank(message = "O atributo email não pode estar em branco")
    private String email;

    @NotBlank(message = "O atributo senha não pode estar em branco")
    @Length(min = 4, max = 10, message = "O atributo senha deve possuir entre 4 e 10 caracteres")
    @NotNull
    private String senha;

    @Column(name = "data_de_nascimento")
    private LocalDate dataDeNascimento;

    public UsuarioEntity(String nome, String login, String email, String senha, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
    }
}
