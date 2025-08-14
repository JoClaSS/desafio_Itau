package com.desafio.itau.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException ex) {
        String message = "JSON inválido ou malformado";
        
        // Se quiser mais detalhes sobre o erro
        if (ex.getCause() instanceof JsonParseException) {
            message = "Erro na sintaxe do JSON: " + ex.getCause().getMessage();
        } else if (ex.getCause() instanceof JsonMappingException) {
            message = "Erro no mapeamento do JSON: " + ex.getCause().getMessage();
        }
        
        return ResponseEntity.badRequest().body(message);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
    return ResponseEntity.unprocessableEntity().body(errors);
}



}



