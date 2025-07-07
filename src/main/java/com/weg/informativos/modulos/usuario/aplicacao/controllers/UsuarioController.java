package com.weg.informativos.modulos.usuario.aplicacao.controllers;

import com.weg.informativos.core.dtos.RespostaDto;
import com.weg.informativos.core.dtos.TokenDto;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import com.weg.informativos.modulos.usuario.dominio.cases.UsuarioLoginCase;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioLoginCase usuarioLoginCase;

    public UsuarioController(UsuarioLoginCase usuarioLoginCase) {
        this.usuarioLoginCase = usuarioLoginCase;
    }

    @PostMapping(value = "/api/usuario/login")
    public ResponseEntity<RespostaDto<TokenDto>> fazerLogin(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto){
        TokenDto token =  usuarioLoginCase.executar(usuarioLoginDto);

        return ResponseEntity.ok(new RespostaDto<TokenDto>("Login realizado com sucesso","LOGIN_REALIZADO", HttpStatus.ACCEPTED.value(), token));
    }

}
