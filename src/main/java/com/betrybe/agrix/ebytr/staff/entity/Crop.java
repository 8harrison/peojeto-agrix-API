package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementação da entity Crop.
 **/
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  private LocalDate plantedDate;

  private LocalDate harvestDate;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizers",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  private List<Fertilizer> fertilizers;

  public Crop() {
  }

  /**
   * Implementaçõ do método construtor da classe Crop.
   **/
  public Crop(Long id, String name, double plantedArea, Farm farm, LocalDate plantedDate,
      LocalDate harvestDate, List<Fertilizer> fertilizers) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
    this.fertilizers = fertilizers;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
