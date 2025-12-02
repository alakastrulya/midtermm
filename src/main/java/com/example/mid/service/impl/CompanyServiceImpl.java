package com.example.mid.service.impl;

import com.example.mid.dto.CompanyDto;
import com.example.mid.entity.Animals;
import com.example.mid.entity.Company;
import com.example.mid.entity.Sponsor;
import com.example.mid.mapper.AnimalsMapper;
import com.example.mid.mapper.CompanyMapper;
import com.example.mid.repository.AnimalRepository;
import com.example.mid.repository.CompanyRepository;
import com.example.mid.repository.SponsorRepository;
import com.example.mid.service.CompanyService;
import com.example.mid.service.SponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final SponsorRepository sponsorRepository;
    @Override
    public List<CompanyDto> getAll() {
        return companyMapper.toDtoList(companyRepository.findAll());
    }

    @Override
    public CompanyDto getById(Long id) {
        return companyMapper.toDto(companyRepository.findById(id).orElse(null));
    }

    @Override
    public CompanyDto addCompany(CompanyDto companyDto) {
        return companyMapper.toDto(companyRepository.save(companyMapper.toEntity(companyDto)));
    }

    @Override
    public CompanyDto updateCompany(Long id, CompanyDto companyDto) {
        Company updated = companyRepository.findById(id).orElseThrow(null);
        updated.setName(companyDto
                .getName());
        updated.setAge(companyDto
                .getAge());
        updated.setQuantityOfAnimals(companyDto
                .getQuantityOfAnimals());
        return companyMapper.toDto(companyRepository.save(updated));
    }

    @Override
    public boolean deleteCompany(Long id) {
        companyRepository.deleteById(id);
        Company company = companyRepository.findById(id).orElse(null);
        if (Objects.isNull(company)) {
            return true;
        }
        return false;
    }


}
