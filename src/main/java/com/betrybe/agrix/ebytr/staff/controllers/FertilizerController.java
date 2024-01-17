package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementação da classe FertilizerController.
 * **/
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService service;

  @Autowired
  public FertilizerController(FertilizerService service) {
    this.service = service;
  }

  /**
   * Implementação do método create.
   * **/
  @PostMapping
  public ResponseEntity<FertilizerDto> create(@RequestBody Fertilizer fertilizer) {
    Fertilizer saved = service.create(fertilizer);
    FertilizerDto fertilizerDto = FertilizerDto.toDto(saved);
    return ResponseEntity.status(HttpStatus.CREATED).body(fertilizerDto);
  }

  /**
   * Implementação do método getAll.
   * **/
  @GetMapping
  @Secured("ADMIN")
  public ResponseEntity<List<FertilizerDto>> getAll() {
    List<Fertilizer> fertilizerList = service.getAll();
    List<FertilizerDto> fertilizerDtoList = fertilizerList.stream()
        .map(FertilizerDto::toDto).toList();
    return ResponseEntity.ok(fertilizerDtoList);
  }

  /**
   * Implementação do método getById.
   * **/
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> getById(@PathVariable Long id) {
    Fertilizer fertilizer = service.getById(id);
    FertilizerDto fertilizerDto = FertilizerDto.toDto(fertilizer);
    return ResponseEntity.ok(fertilizerDto);
  }
}
