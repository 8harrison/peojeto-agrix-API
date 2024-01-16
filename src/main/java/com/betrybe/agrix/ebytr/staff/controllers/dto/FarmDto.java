package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Implementação da classe FarmDTO.
 * **/
public record FarmDto(Long id, String name, double size) {

  public Farm toEntity() {
    return new Farm(id, name, size, null);
  }

  /**
   * Implementação do método toDto.
   * **/
  public static FarmDto toDto(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }
}
