package com.miModeloParcial.modeloParcial.Common.Exception;

import com.miModeloParcial.modeloParcial.Common.Dto.ErrorResponseDTO;
import com.miModeloParcial.modeloParcial.Reactivos.Exception.ReactivoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    // 404 NOT FOUND
    @ExceptionHandler(ReactivoNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarReactivoNoEncontrado(ReactivoNoEncontradoException ex)
    {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    ///  en String poner ErrorResponseDTO. arreglarlo, tambien debo crear el ErrorResponseDTO en common, ver el proyecto del chico para guiarme.
    ///
    /// ASI QUEDARIA EL GLOBAL HANDLER CON UNA EXCEPCION DONDE NO TENGAMOS ERRORRESPONSEDTO. ES MUY FACIL
    /// // 404 NOT FOUND
    ///     @ExceptionHandler(ReactivoNoEncontradoException.class)
    ///     public ResponseEntity<String> manejarReactivoNoEncontrado(ReactivoNoEncontradoException ex)
    ///     {
    ///         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    ///     }


    private ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus status, String message) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message
        );
        return new ResponseEntity<>(error, status);
    }
}
