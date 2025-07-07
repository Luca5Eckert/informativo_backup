package com.weg.informativos.core.exceptions;

import com.weg.informativos.core.dtos.ErroDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//lida com excessões lançadas pelo sistemas
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDto> handleRuntimeException(RuntimeException re, HttpServletRequest request) {
        String message = re.getMessage();
        String uniqueCode = "RUNTIME_EXCEPTION";
        int status = HttpStatus.BAD_REQUEST.value();
        String path = request.getRequestURI();
        String method = request.getMethod();

        return ResponseEntity.badRequest().body(new ErroDto(message, uniqueCode, status, path, method));

    }

}
