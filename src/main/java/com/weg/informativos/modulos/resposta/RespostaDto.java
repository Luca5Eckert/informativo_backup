package com.weg.informativos.modulos.resposta;

import org.springframework.http.HttpStatus;

public record RespostaDto(int httpStatus, String mensagem, Object dado ) {
}
