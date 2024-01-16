package com.betrybe.agrix.evaluation.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

  @Autowired
  private PersonService service;

  @Test
  public void testGetPersonById() {
    Person person = new Person();
    person.setPassword("123456");
    person.setRole(Role.USER);
    person.setUsername("Adamastor Castannheiras");

    Person saved = service.create(person);

    Person founded = service.getPersonById(saved.getId());

    assertEquals(saved.getPassword(), founded.getPassword());
    assertEquals(saved.getRole(), founded.getRole());
    assertEquals(saved.getUsername(), founded.getUsername());
  }

  @Test
  public void testGetPersonByIdNotFound() {
    assertThrows(PersonNotFoundException.class, () ->
        service.getPersonById(100L));
  }

  @Test
  public void testGetPersonByUsername() {
    Person person = new Person();
    person.setUsername("Setembrino Arruda");
    person.setRole(Role.USER);
    person.setPassword("654321");

    Person saved = service.create(person);

    Person founded = service.getPersonByUsername(person.getUsername());

    assertEquals(saved.getUsername(), founded.getUsername());
    assertEquals(saved.getRole(), founded.getRole());
    assertEquals(saved.getPassword(), founded.getPassword());
  }

  @Test
  public void testGetPersonByUsernameNotFound() {
    assertThrows(PersonNotFoundException.class, () ->
        service.getPersonByUsername("Severino cajueiro"));
  }

  @Test
  public void testCreate() {
    Person person = new Person();
    person.setPassword("abcdef");
    person.setUsername("Coralina de Oliveira");
    person.setRole(Role.ADMIN);

    Person saved = service.create(person);

    assertEquals(person.getPassword(), saved.getPassword());
    assertEquals(person.getRole(), saved.getRole());
    assertEquals(person.getUsername(), saved.getUsername());
  }
}
