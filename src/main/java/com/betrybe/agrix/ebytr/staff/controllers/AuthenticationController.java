//package com.betrybe.agrix.ebytr.staff.controllers;
//
//import com.betrybe.agrix.ebytr.staff.controllers.dto.PersonDto;
//import com.betrybe.agrix.ebytr.staff.entity.Person;
//import com.betrybe.agrix.ebytr.staff.service.PersonService;
//import com.betrybe.agrix.ebytr.staff.service.TokenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Implementação da classe AuthenticationController.
// **/
//@RestController
//@RequestMapping("/auth")
//public class AuthenticationController {
//
//  private final AuthenticationManager authenticationManager;
//
//  private final PersonService personService;
//
//  private final TokenService tokenService;
//
//  /**
//   * Implementação do método construtor.
//   **/
//  @Autowired
//  public AuthenticationController(AuthenticationManager authenticationManager,
//      PersonService personService, TokenService tokenService) {
//    this.authenticationManager = authenticationManager;
//    this.personService = personService;
//    this.tokenService = tokenService;
//  }
//
//
//}
