package com.miModeloParcial.modeloParcial.Common.Exception;

import com.miModeloParcial.modeloParcial.Reactivos.Exception.ReactivoNoEncontradoException;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    // 404 NOT FOUND
    @ExceptionHandler(ReactivoNoEncontradoException.class)
    public ResponseEntity<String> manejarReactivoNoEncontrado(ReactivoNoEncontradoException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
