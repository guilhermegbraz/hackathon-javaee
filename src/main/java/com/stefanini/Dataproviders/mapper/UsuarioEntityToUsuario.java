package com.stefanini.Dataproviders.mapper;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;

public class UsuarioEntityToUsuario {
    public Usuario execute(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(), usuarioEntity.getNome(), usuarioEntity.getLogin(),
                usuarioEntity.getEmail(), usuarioEntity.getSenha(), usuarioEntity.getDataDeNascimento());
    }
}
