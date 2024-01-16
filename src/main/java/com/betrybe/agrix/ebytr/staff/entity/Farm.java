package com.betrybe.agrix.ebytr.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Implementação da classe Farm.
 * **/
@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private double size;

  @OneToMany(mappedBy = "farm")
  @JsonIgnore
  private List<Crop> crops;

  /**
   * Implementação do método construtor de Farm vazio.
   * **/
  public Farm() {
  }

  /**
   * Implementação do método construtor de Farm com atributos.
   * **/
  public Farm(Long id, String name, double size, List<Crop> crops) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.crops = crops;
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

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}
