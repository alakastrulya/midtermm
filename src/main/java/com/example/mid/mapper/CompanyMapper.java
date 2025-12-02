package com.example.mid.mapper;

import com.example.mid.dto.CompanyDto;
import com.example.mid.entity.Company;
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
