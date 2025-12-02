package com.example.mid.mapper;

import com.example.mid.dto.AnimalsDto;
import com.example.mid.entity.Animals;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SponsorMapper.class, CompanyMapper.class})
public interface AnimalsMapper {

    AnimalsDto toDto(Animals animals);
    Animals toEntity(AnimalsDto animalsDto);
    List<AnimalsDto> toDtoList(List<Animals> animalsList);
}
