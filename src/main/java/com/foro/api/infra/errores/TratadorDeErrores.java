package com.foro.api.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {

    // detecta la excepcion que se va a tratar en el metodo.
    // Esta excepcion aparece cuando se busca un usuario que no existe o un topico en este caso
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        //return ResponseEntity.notFound().build();
        return ResponseEntity.badRequest().body("Este topico no existe");
    }

    // Esta excepcion aparece cuando no se estan ingresando los datos completos
    @ExceptionHandler(MethodArgumentNotValidException.class) //
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(datosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionDeIntegridad.class) //
    public ResponseEntity errorHandlerValidacionesDeIntegridad(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class) //
    public ResponseEntity errorHandlerValidacionesDeNegocio(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record datosErrorValidacion(String campo, String error){
        public datosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        String errorMessage = "Este titulo o este mensaje ya existen dentro del Foro, o no deben ser nulos: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


}
