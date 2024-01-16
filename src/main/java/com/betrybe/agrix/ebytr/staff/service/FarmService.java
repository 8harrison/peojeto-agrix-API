package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.IdNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da classe FarmService.
 **/
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Implementação do método getFarmById.
   **/
  public Farm getFarmById(Long id) {
    Optional<Farm> optional = farmRepository.findById(id);

    if (optional.isEmpty()) {
      throw new IdNotFoundException("Fazenda não encontrada!");
    }

    return optional.get();
  }

  /**
   * Implementação do método createCrop.
   **/
  public Crop createCrop(Long farmId, Crop crop) {
    Optional<Farm> optional = farmRepository.findById(farmId);

    if (optional.isEmpty()) {
      throw new IdNotFoundException("Fazenda não encontrada!");
    }

    Crop createdCrop = cropRepository.save(crop);
    Farm farm = optional.get();
    createdCrop.setFarm(farm);
    return cropRepository.save(createdCrop);
  }

  /**
   * Implementação do método getAllCropsByFarmId.
   **/
  public List<Crop> getAllCropsByFarmId(Long farmId) {
    Optional<Farm> optional = farmRepository.findById(farmId);

    if (optional.isEmpty()) {
      throw new IdNotFoundException("Fazenda não encontrada!");
    }

    return optional.get().getCrops();
  }

}
