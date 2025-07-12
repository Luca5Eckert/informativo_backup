package com.weg.informativos.modulos.informativo.aplicacao.dtos;

import com.weg.informativos.modulos.tag.aplicacao.dtos.TagDto;

import java.util.Set;

public record CriarInformativoRequest(String titulo, String conteudo, int nivelImportancia, Set<TagDto> tags) {
}
