package com.weg.informativos.modulos.usuario.aplicacao.controllers;

import com.weg.informativos.modulos.resposta.RespostaDto;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import com.weg.informativos.modulos.usuario.dominio.casos.UsuarioLoginCaso;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioLoginCaso usuarioLoginCaso;

    public UsuarioController(UsuarioLoginCaso usuarioLoginCaso) {
        this.usuarioLoginCaso = usuarioLoginCaso;
    }

    @PostMapping(value = "/api/usuario/login")
    public ResponseEntity<RespostaDto> fazerLogin(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto){
        usuarioLoginCaso.executar(usuarioLoginDto);
        return ResponseEntity.ok(new RespostaDto(200, "Usuario mogado com sucesso", null));
    }

}
