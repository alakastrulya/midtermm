package com.example.midtermm.service.impl;

import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.dto.SponsorDto;
import com.example.midtermm.entity.Animals;
import com.example.midtermm.entity.Company;
import com.example.midtermm.entity.Sponsor;
import com.example.midtermm.mapper.SponsorMapper;
import com.example.midtermm.repository.AnimalRepository;
import com.example.midtermm.repository.CompanyRepository;
import com.example.midtermm.repository.SponsorRepository;
import com.example.midtermm.service.SponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SponsorServiceImpl implements SponsorService {
    private final SponsorRepository sponsorRepository;
    private final SponsorMapper sponsorMapper;
    private final AnimalRepository animalRepository;
    private final CompanyRepository companyRepository;
    @Override
    public List<SponsorDto> getAll() {
        return sponsorMapper.toDtoList(sponsorRepository.findAll());
    }

    @Override
    public SponsorDto getById(Long id) {
        return sponsorMapper.toDto(sponsorRepository.findById(id).orElse(null));
    }

    @Override
    public SponsorDto addSponsor(SponsorDto sponsorDto) {
        Sponsor sponsor = sponsorMapper.toEntity(sponsorDto);
        setCompanyFromDto(sponsor,sponsorDto);

        return sponsorMapper.toDto(sponsorRepository.save(sponsor));
    }

    @Override
    public SponsorDto updateSponsor(Long id, SponsorDto sponsorDto) {
        Sponsor updated = sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor with id " + id + " not found"));        updated.setName(sponsorDto.getNameDto());
        updated.setBank(sponsorDto.getBankDto());
        setCompanyFromDto(updated,sponsorDto);

        if(sponsorDto.getAnimals()!=null && !sponsorDto.getAnimals().isEmpty()){
            List<Animals> animalsList = new ArrayList<>();
            for(AnimalsDto animalsDto: sponsorDto.getAnimals()){
                Animals animal = new Animals();
                animal.setId(animalsDto.getId());
                animalsList.add(animal);
            }
            updated.setAnimals(animalsList);
        }else{
            updated.setAnimals(null);

        }
        sponsorRepository.save(updated);
        return sponsorMapper.toDto(sponsorRepository.save(updated));


    }

    @Override
    public boolean deleteSponsor(Long id) {
        Sponsor sponsor = sponsorRepository.getById(id);
        if(Objects.isNull(sponsor)){
            return false;
        }else{
            sponsorRepository.delete(sponsor);
            return true;
        }
    }

    private void setCompanyFromDto(Sponsor sponsor, SponsorDto sponsorDto){
        if(sponsorDto.getCompany()!=null && sponsorDto.getCompany().getId()!=null){
            Company company = companyRepository.findById(sponsorDto.getCompany().getId()).orElse(null);
            sponsor.setCompany(company);

        }else{
            sponsor.setCompany(null);
        }
        sponsorRepository.save(sponsor);
    }
}
