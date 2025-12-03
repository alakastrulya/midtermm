package com.example.midtermm.mapper;

import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "age", source = "age")
    @Mapping(target = "quantityOfAnimals", source = "quantityOfAnimals")
    CompanyDto toDto(Company company);
    Company toEntity(CompanyDto companyDto);
    List<CompanyDto> toDtoList(List<Company> companyList);

}
