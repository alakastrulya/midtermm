package com.example.midtermm.service;

import com.example.midtermm.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAll();
    CompanyDto getById(Long id);
    CompanyDto addCompany(CompanyDto companyDto);
    CompanyDto updateCompany(Long id,CompanyDto companyDto);
    boolean deleteCompany(Long id);

}
