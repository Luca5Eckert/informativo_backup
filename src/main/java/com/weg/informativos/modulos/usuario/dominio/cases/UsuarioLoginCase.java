package com.weg.informativos.modulos.usuario.dominio.cases;

import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import com.weg.informativos.modulos.usuario.aplicacao.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginCase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioLoginCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void executar(UsuarioLoginDto userUsuarioLoginDto){

    }

}
