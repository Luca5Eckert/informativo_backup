package com.weg.informativos.modulos.informativo.aplicacao.dtos;

import com.weg.informativos.modulos.tag.aplicacao.dtos.TagDto;
import com.weg.informativos.modulos.tag.dominio.TagEntidade;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioDto;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import jakarta.validation.Valid;

import java.util.Set;

public record CriarInformativoCommand(String titulo, String conteudo, UsuarioEntidade criadoPor, int nivelImportancia, Set<TagDto> tags) {
    public CriarInformativoCommand(@Valid CriarInformativoRequest criarInformativoRequest, UsuarioEntidade usuarioEntidade) {
        this(criarInformativoRequest.titulo(), criarInformativoRequest.conteudo(), usuarioEntidade, criarInformativoRequest.nivelImportancia(), criarInformativoRequest.tags());
    }
}
