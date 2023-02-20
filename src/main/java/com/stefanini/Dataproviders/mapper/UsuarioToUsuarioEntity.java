package com.stefanini.Dataproviders.mapper;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;

public class UsuarioToUsuarioEntity {
    public UsuarioEntity execute(Usuario usuario) {
        return new UsuarioEntity(usuario.getNome(), usuario.getLogin(),
                usuario.getEmail(), usuario.getSenha(), usuario.getDataDeNascimento());
    }
}
