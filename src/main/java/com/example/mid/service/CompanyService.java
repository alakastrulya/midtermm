package com.example.mid.service;

import com.example.mid.dto.AnimalsDto;
import com.example.mid.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAll();
    CompanyDto getById(Long id);
    CompanyDto addCompany(CompanyDto companyDto);
    CompanyDto updateCompany(Long id,CompanyDto companyDto);
    boolean deleteCompany(Long id);

}
