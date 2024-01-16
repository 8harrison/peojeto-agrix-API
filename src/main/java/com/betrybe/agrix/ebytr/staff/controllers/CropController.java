package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementação da classe CropController.
 **/
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Implementação do método getAllCrops.
   **/
  @GetMapping
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();
    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::toDto).toList();
    return ResponseEntity.ok(cropDtoList);
  }

  /**
   * Implementação do método getCropById.
   **/
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);
    CropDto cropDto = CropDto.toDto(crop);
    return ResponseEntity.ok(cropDto);
  }

  /**
   * Implementação do método getAllCropsHarvestDateBetween.
   **/
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getAllCropsHarvestDateBetween(@RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    List<Crop> crops = cropService.getAllCropsHarvestDateBetween(start, end);
    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::toDto).toList();
    return ResponseEntity.ok(cropDtoList);
  }

  /**
   * Implementação do método createFertilizer.
   **/
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> createFertilizer(@PathVariable Long cropId,
      @PathVariable Long fertilizerId) {
    cropService.createFertilizer(cropId, fertilizerId);
    String message = "Fertilizante e plantação associados com sucesso!";
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  /**
   * Implementação do método getAllFertilizersByCropId.
   * **/
  @GetMapping("/{id}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getAllFertilizersByCropId(@PathVariable Long id) {
    List<Fertilizer> fertilizers = cropService.getAllFertilizersByCropId(id);
    List<FertilizerDto> fertilizerDtoList = fertilizers.stream()
        .map(FertilizerDto::toDto).toList();
    return ResponseEntity.ok(fertilizerDtoList);
  }
}
