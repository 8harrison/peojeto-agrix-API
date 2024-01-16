package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.IdNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da classe CropService.
 **/
@Service
public class CropService {

  private final CropRepository cropRepository;

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Implementação do método getCropById.
   **/
  public Crop getCropById(Long id) {
    Optional<Crop> optional = cropRepository.findById(id);

    if (optional.isEmpty()) {
      throw new IdNotFoundException("Plantação não encontrada!");
    }

    return optional.get();
  }

  public List<Crop> getAllCropsHarvestDateBetween(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Implementação do método createFertilizer.
   **/
  public void createFertilizer(Long cropId, Long fertilizerId) {
    Optional<Crop> optionalCrop = cropRepository.findById(cropId);
    if (optionalCrop.isEmpty()) {
      throw new IdNotFoundException("Plantação não encontrada!");
    }

    Optional<Fertilizer> optionalFertilizer = fertilizerRepository.findById(fertilizerId);
    if (optionalFertilizer.isEmpty()) {
      throw new IdNotFoundException("Fertilizante não encontrado!");
    }

    Crop crop = optionalCrop.get();
    Fertilizer fertilizer = optionalFertilizer.get();

    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);
  }

  /**
   * Implementação do método getAllFertilizersByCropId.
   * **/
  public List<Fertilizer> getAllFertilizersByCropId(Long id) {
    Optional<Crop> optional = cropRepository.findById(id);
    if (optional.isEmpty()) {
      throw new IdNotFoundException("Plantação não encontrada!");
    }
    return optional.get().getFertilizers();
  }
}
