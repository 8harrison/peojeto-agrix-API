package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementação da classe PersonController.
 * **/
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Implementação do método register.
   **/
  @PostMapping
  public ResponseEntity<PersonDto> register(@RequestBody Person person) {
    UserDetails userDetails = personService.loadUserByUsername(person.getUsername());
    if (userDetails != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PersonDto.toDto(person));
    }
    Person saved = personService.create(person);
    return ResponseEntity.status(HttpStatus.CREATED).body(PersonDto.toDto(saved));
  }
}
