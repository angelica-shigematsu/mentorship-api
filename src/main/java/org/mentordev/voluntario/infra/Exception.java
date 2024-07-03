package org.mentordev.voluntario.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class Exception {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity manageDuplicateEntry(DataIntegrityViolationException ex) {
        var message = "Tente outro email";

        var erro = new DuplicateEntry("email", message);
        return ResponseEntity.badRequest().body(erro);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manageErro400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors.stream().map(ErroValidationDTO::new).toList());
    }

    public record DuplicateEntry(String field, String message) {

    }

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity manageErro500(java.lang.Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
    }

    private record ErroValidationDTO(String field, String message) {
        public ErroValidationDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
