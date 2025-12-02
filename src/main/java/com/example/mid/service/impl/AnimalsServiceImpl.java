package com.example.mid.service.impl;

import com.example.mid.dto.AnimalsDto;
import com.example.mid.dto.SponsorDto;
import com.example.mid.entity.Animals;
import com.example.mid.entity.Sponsor;
import com.example.mid.mapper.AnimalsMapper;
import com.example.mid.repository.AnimalRepository;
import com.example.mid.repository.SponsorRepository;
import com.example.mid.service.AnimalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
