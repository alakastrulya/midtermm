package com.example.mid.service;

import com.example.mid.dto.AnimalsDto;
import com.example.mid.entity.Animals;

import java.util.List;

public interface AnimalsService {

    List<AnimalsDto> getAll();
    AnimalsDto getById(Long id);
    AnimalsDto addAnimals(AnimalsDto animalsDto);
    AnimalsDto updateAnimals(Long id,AnimalsDto animalsDto);
    boolean deleteAnimals(Long id);

}
