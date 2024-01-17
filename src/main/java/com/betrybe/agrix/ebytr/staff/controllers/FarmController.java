package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
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
 * Implementação da classe FarmController.
 **/
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
    Farm createdFarm = farmService.createFarm(farm);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdFarm);
  }

  @GetMapping
  @Secured({"USER", "MANAGER", "ADMIN"})
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    return ResponseEntity.ok(farms);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
    Farm farm = farmService.getFarmById(id);
    return ResponseEntity.ok(farm);
  }

  /**
   * Implementação do método creatCrop.
   **/
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(@PathVariable Long farmId, @RequestBody Crop crop) {
    Crop createdCrop = farmService.createCrop(farmId, crop);
    CropDto cropDto = CropDto.toDto(createdCrop);
    return ResponseEntity.status(HttpStatus.CREATED).body(cropDto);
  }

  /**
   * Implementação do método getAllCropsByFarmId.
   **/
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getAllCropsByFarmId(@PathVariable Long farmId) {
    List<Crop> crops = farmService.getAllCropsByFarmId(farmId);
    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::toDto)
        .toList();
    return ResponseEntity.ok(cropDtoList);
  }

}
