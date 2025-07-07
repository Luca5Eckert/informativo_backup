package com.weg.informativos.core.dtos;

import java.time.LocalDateTime;

public record RespostaDto<T>( String mensagem, String uniqueCode, int status, T dados, LocalDateTime timeStamp ) {
}
