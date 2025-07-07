package com.weg.informativos.modulos.usuario.aplicacao.controllers;

import com.weg.informativos.core.dtos.RespostaDto;
import com.weg.informativos.core.dtos.TokenDto;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioCadastroDto;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import com.weg.informativos.modulos.usuario.dominio.cases.UsuarioCadastroCase;
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

    private final UsuarioCadastroCase usuarioCadastroCase;

    public UsuarioController(UsuarioLoginCase usuarioLoginCase, UsuarioCadastroCase usuarioCadastroCase) {
        this.usuarioLoginCase = usuarioLoginCase;
        this.usuarioCadastroCase = usuarioCadastroCase;
    }

    @PostMapping(value = "/api/usuario/login")
    public ResponseEntity<RespostaDto<TokenDto>> fazerLogin(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto){
        TokenDto token =  usuarioLoginCase.executar(usuarioLoginDto);

        return ResponseEntity.ok(new RespostaDto<TokenDto>("Login realizado com sucesso","LOGIN_REALIZADO", HttpStatus.ACCEPTED.value(), token));
    }

    @PostMapping(value = "/api/usuario/cadastro")
    public ResponseEntity<RespostaDto<TokenDto>> fazerCadastro(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        usuarioCadastroCase.executar(usuarioCadastroDto);

        return ResponseEntity.ok(new RespostaDto<TokenDto>("Cadastro realizado com sucesso","CADASTRO_REALIZADO", HttpStatus.ACCEPTED.value(), null));
    }

}
