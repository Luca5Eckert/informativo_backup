package com.weg.informativos.core.dtos;

import java.time.LocalDateTime;

public record ErroDto(String message, String uniqueCode, int status, String path, String method, LocalDateTime timeStamp) {
    public ErroDto(String message, String uniqueCode, int status, String path, String method){
        this(message, uniqueCode, status, path, method, LocalDateTime.now());
    }


}
