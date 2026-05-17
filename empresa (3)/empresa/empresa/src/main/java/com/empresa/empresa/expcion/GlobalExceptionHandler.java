package com.empresa.empresa.expcion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        // LinkedHashMap mantiene el orden de inserción
        Map<String, String> errores = new LinkedHashMap<>();

        // Recorre todos los errores del DTO
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage())
        );

        // 400 = Bad Request
        return ResponseEntity.badRequest().body(errores);
    }

    // ── ERROR DE NEGOCIO ────────────────────────────
    // Se ejecuta cuando el Service lanza RuntimeException
    // Ejemplo:
    // "Empresa no encontrada"

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(
            RuntimeException ex) {

        Map<String, String> error = new LinkedHashMap<>();

        error.put("error", ex.getMessage());

        // 400 = Bad Request
        return ResponseEntity.badRequest().body(error);
    }
}