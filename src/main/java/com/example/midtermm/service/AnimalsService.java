package com.example.midtermm.service;

import com.example.midtermm.dto.AnimalsDto;

import java.util.List;

public interface AnimalsService {

    List<AnimalsDto> getAll();
    AnimalsDto getById(Long id);
    AnimalsDto addAnimals(AnimalsDto animalsDto);
    AnimalsDto updateAnimals(Long id,AnimalsDto animalsDto);
    boolean deleteAnimals(Long id);

}
