package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.IdNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da classe FertilizerService.
 * **/
@Service
public class FertilizerService {

  private final FertilizerRepository repository;

  @Autowired
  public FertilizerService(FertilizerRepository repository) {
    this.repository = repository;
  }

  public Fertilizer create(Fertilizer fertilizer) {
    return repository.save(fertilizer);
  }

  public List<Fertilizer> getAll() {
    return repository.findAll();
  }

  /**
   * Implementação do método getById.
   * **/
  public Fertilizer getById(Long id) {
    Optional<Fertilizer> optional = repository.findById(id);
    if (optional.isEmpty()) {
      throw new IdNotFoundException("Fertilizante não encontrado!");
    }
    return optional.get();
  }
}
