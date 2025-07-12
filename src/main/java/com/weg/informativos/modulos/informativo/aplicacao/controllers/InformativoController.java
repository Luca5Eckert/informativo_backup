package com.weg.informativos.modulos.informativo.aplicacao.controllers;

import com.weg.informativos.core.dtos.RespostaDto;
import com.weg.informativos.core.security.UserAuthenticationService;
import com.weg.informativos.modulos.informativo.aplicacao.dtos.CriarInformativoCommand;
import com.weg.informativos.modulos.informativo.aplicacao.dtos.CriarInformativoRequest;
import com.weg.informativos.modulos.informativo.dominio.cases.AdicionarInformativoCase;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/informativo")
public class InformativoController {

    private final AdicionarInformativoCase adicionarInformativoCase;

    public InformativoController(AdicionarInformativoCase adicionarInformativoCase) {
        this.adicionarInformativoCase = adicionarInformativoCase;
    }

    @PutMapping
    public ResponseEntity<RespostaDto> adicionarInformativo(@RequestBody @Valid CriarInformativoRequest criarInformativoRequest){
        UsuarioEntidade usuario = UserAuthenticationService.getUser().getUsuario();

        CriarInformativoCommand criarInformativoCommand = new CriarInformativoCommand(criarInformativoRequest, usuario);

        adicionarInformativoCase.executar(criarInformativoCommand);

        return ResponseEntity.accepted().body(new RespostaDto("Informativo adicionado com sucesso", "INFORMATIVO_ADICIONADO", HttpStatus.ACCEPTED.value(), null));
    }



}
