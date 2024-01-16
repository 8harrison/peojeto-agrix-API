package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * Implementação do record FertilizerDto.
 * **/
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Implementação do método toDto.
   * **/
  public static FertilizerDto toDto(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }
}
