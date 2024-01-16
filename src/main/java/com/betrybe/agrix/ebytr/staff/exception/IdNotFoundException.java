package com.betrybe.agrix.ebytr.staff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implementação da classe exception IdNotFoundException.
 * **/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

  public IdNotFoundException(String message) {
    super(message);
  }
}
