package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;

/**
 * Implementação da classe TokenService.
 **/
@Service
public class TokenService {


  private final Algorithm algorithm;

  public TokenService() {
    this.algorithm = Algorithm.HMAC256(secret());
  }


  /**
   * Implementação do método generateToken.
   **/
  public String generateToken(Person person) {
    return JWT.create()
        .withIssuer("agrix")
        .withSubject(person.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now()
        .plusHours(2)
        .toInstant(ZoneOffset.of("-03:00"));
  }

  /**
   * Implementação do método validateToken.
   **/
  public String validateToken(String token) {
    return JWT.require(algorithm)
        .withIssuer("agrix")
        .build()
        .verify(token)
        .getSubject();
  }

  private String secret() {
    StringBuilder secret = new StringBuilder();
    for (int i = 0; i < 11; i++) {
      secret.append(Math.random());
    }
    return secret.toString();
  }
}
