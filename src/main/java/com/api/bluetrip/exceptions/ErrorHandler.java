package com.api.bluetrip.exceptions;

import com.api.bluetrip.controllers.dtos.ErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFoundError() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleBadRequestError(MethodArgumentNotValidException ex) {
        List<FieldError> errorsList = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errorsList.stream().map(ErrorDataValidation::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleBadRequestError(HttpMessageNotReadableException ex) {
        ErrorDTO error = new ErrorDTO(ex.getClass().getName(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedError(AccessDeniedException ex) {
        ErrorDTO error = new ErrorDTO(ex.getClass().getName(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleInternalServerError(Exception ex) {
        ErrorDTO error = new ErrorDTO(ex.getClass().getName(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    private record ErrorDataValidation(String field, String message){
        public ErrorDataValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
