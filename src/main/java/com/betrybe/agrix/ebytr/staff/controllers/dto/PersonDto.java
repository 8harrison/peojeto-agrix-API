package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;

/**
 * Implementação do record PersonDto.
 * **/
public record PersonDto(Long id, String username, String role) {

  /**
   * Implementação do método toDto.
   * **/
  public static PersonDto toDto(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole().name()
    );
  }
}
