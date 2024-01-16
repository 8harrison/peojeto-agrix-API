package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Implementação do record CropDto.
 **/
public record CropDto(Long id, String name, double plantedArea, Long farmId, LocalDate plantedDate,
                      LocalDate harvestDate) {

  /**
   * Implementação do método toDto.
   * **/
  public static CropDto toDto(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }
}
