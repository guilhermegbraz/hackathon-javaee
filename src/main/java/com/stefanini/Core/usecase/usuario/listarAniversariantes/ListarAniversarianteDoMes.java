package com.stefanini.Core.usecase.usuario.listarAniversariantes;

import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;

import java.util.List;

public class ListarAniversarianteDoMes {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto;

    public ListarAniversarianteDoMes(UsuarioRepository usuarioRepository, UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioToExibirUsuarioDto = usuarioToExibirUsuarioDto;
    }

    public List<ExibirUsuarioDto> execute(Integer mes) {
        var aniversariantes = this.usuarioRepository.listarAniversariantesDoMes(mes);

        return this.usuarioToExibirUsuarioDto.execute(aniversariantes);
    }
}
