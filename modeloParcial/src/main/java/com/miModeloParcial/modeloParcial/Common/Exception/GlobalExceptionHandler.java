package com.miModeloParcial.modeloParcial.Common.Exception;

import com.miModeloParcial.modeloParcial.Lotes.Exception.LoteNoEncontradoException;
import com.miModeloParcial.modeloParcial.Reactivos.Exception.ReactivoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {


    ///  en String poner ErrorResponseDTO. arreglarlo, tambien debo crear el ErrorResponseDTO en common, ver el proyecto del chico para guiarme.
    ///
    /// ASI QUEDARIA EL GLOBAL HANDLER CON UNA EXCEPCION DONDE NO TENGAMOS ERRORRESPONSEDTO. ES MUY FACIL
    ///
    /// // 404 NOT FOUND
       @ExceptionHandler(ReactivoNoEncontradoException.class)
       public ResponseEntity<String> manejarReactivoNoEncontrado(ReactivoNoEncontradoException ex)
       {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
       }

       @ExceptionHandler(LoteNoEncontradoException.class)
        public ResponseEntity<String> manejarLoteNoEncontrado(LoteNoEncontradoException e)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }



        /*
    /// esto es obligatorio para crear el response
    private ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus status, String message) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message
        );
        return new ResponseEntity<>(error, status);
    }

         */
}
