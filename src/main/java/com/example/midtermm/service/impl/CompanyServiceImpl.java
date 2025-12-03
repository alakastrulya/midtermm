package com.example.midtermm.service.impl;

import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.entity.Company;
import com.example.midtermm.mapper.CompanyMapper;
import com.example.midtermm.repository.CompanyRepository;
import com.example.midtermm.repository.SponsorRepository;
import com.example.midtermm.service.CompanyService;
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
