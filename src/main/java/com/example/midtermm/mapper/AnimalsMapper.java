package com.example.midtermm.mapper;

import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.entity.Animals;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SponsorMapper.class, CompanyMapper.class})
public interface AnimalsMapper {

    AnimalsDto toDto(Animals animals);
    Animals toEntity(AnimalsDto animalsDto);
    List<AnimalsDto> toDtoList(List<Animals> animalsList);
}
