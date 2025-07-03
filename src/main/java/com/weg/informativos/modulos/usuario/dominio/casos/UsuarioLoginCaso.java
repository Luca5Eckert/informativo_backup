package com.weg.informativos.modulos.usuario.dominio.casos;

import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import com.weg.informativos.modulos.usuario.aplicacao.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginCaso {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioLoginCaso(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void executar(UsuarioLoginDto userUsuarioLoginDto){

    }

}
