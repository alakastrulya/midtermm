package com.example.midtermm.service.impl;

import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.entity.Animals;
import com.example.midtermm.entity.Sponsor;
import com.example.midtermm.mapper.AnimalsMapper;
import com.example.midtermm.repository.AnimalRepository;
import com.example.midtermm.repository.SponsorRepository;
import com.example.midtermm.service.AnimalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalsServiceImpl implements AnimalsService {
    private final AnimalRepository animalRepository;
    private final AnimalsMapper animalsMapper;
    private final SponsorRepository sponsorRepository;
    @Override
    public List<AnimalsDto> getAll() {
        return animalsMapper.toDtoList(animalRepository.findAll());
    }

    @Override
    public AnimalsDto getById(Long id) {
        return animalsMapper.toDto(animalRepository.findById(id).orElse(null));
    }

    @Override
    public AnimalsDto addAnimals(AnimalsDto animalsDto) {
        return animalsMapper.toDto(animalRepository.save(animalsMapper.toEntity(animalsDto)));
    }

    @Override
    public AnimalsDto updateAnimals(Long id, AnimalsDto animalsDto) {

        Animals updated = animalRepository.findById(id).orElseThrow();
        updated.setName(animalsDto
                .getName());
        updated.setType(animalsDto
                .getType());
        updated.setAge(animalsDto
                .getAge());
        return animalsMapper.toDto(animalRepository.save(updated));

    }

    @Override
    public boolean deleteAnimals(Long id) {
        Animals animal = animalRepository.findById(id).orElse(null);
        if (animal == null) {
            return false;
        }

        List<Sponsor> sponsors = sponsorRepository.findAllByAnimalsContaining(animal);
        for (Sponsor sponsor : sponsors) {
            sponsor.getAnimals().remove(animal);
            sponsorRepository.save(sponsor);
        }

        animalRepository.deleteById(id);
        return true;
    }
}
