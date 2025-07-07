package com.weg.informativos.modulos.usuario.aplicacao.dtos;

import com.weg.informativos.modulos.usuario.dominio.enums.TipoUsuario;

import java.util.UUID;

public record UsuarioDto(UUID id, String nome, String email, TipoUsuario tipoUsuario) {
}
