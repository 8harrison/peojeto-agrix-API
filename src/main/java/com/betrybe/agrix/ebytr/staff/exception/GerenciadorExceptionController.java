package com.betrybe.agrix.ebytr.staff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Implementação do gerenciador de exception GerenciadorExceptionController.
 * **/
@ControllerAdvice
public class GerenciadorExceptionController {

  /**
   * Implementação do método da exception IdNotFoundException.
   * **/
  @ExceptionHandler({IdNotFoundException.class})
  public ResponseEntity<String> handleIdNotFound(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }
}
