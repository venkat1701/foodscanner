package io.github.venkat1701.foodscannerbackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.View;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler
    public ResponseEntity<List<String>> handleExceptions(Exception e) {
        List<String> errorList = List.of(e.getMessage());
        return ResponseEntity.ok(errorList);
    }
}
