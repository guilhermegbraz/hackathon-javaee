package com.stefanini.Dataproviders.mapper;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEntityToUsuario {
    public Usuario execute(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(), usuarioEntity.getNome(), usuarioEntity.getLogin(),
                usuarioEntity.getEmail(), usuarioEntity.getSenha(), usuarioEntity.getDataDeNascimento());
    }

    public List<Usuario> execute(List<UsuarioEntity> usuarioEntityList) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioEntityList.forEach(usuarioEntity -> usuarios.add(this.execute(usuarioEntity)));

        return usuarios;
    }
}
