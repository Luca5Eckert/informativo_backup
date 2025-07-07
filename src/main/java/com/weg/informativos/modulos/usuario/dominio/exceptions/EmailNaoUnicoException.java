package com.weg.informativos.modulos.usuario.dominio.exceptions;

public class EmailNaoUnicoException extends RuntimeException {
    public EmailNaoUnicoException(String message) {
        super(message);
    }
}
