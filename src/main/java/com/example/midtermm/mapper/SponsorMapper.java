package com.example.midtermm.mapper;


import com.example.midtermm.dto.SponsorDto;
import com.example.midtermm.entity.Sponsor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SponsorMapper {
    @Mapping(target="idDto",source="id")
    @Mapping(target="nameDto",source="name")
    @Mapping(target="bankDto",source="bank")
    @Mapping(target = "company", source = "company")
    @Mapping(target = "animals", source = "animals")
    SponsorDto toDto(Sponsor sponsor);

    @Mapping(target="id",source="idDto")
    @Mapping(target="name",source="nameDto")
    @Mapping(target="bank",source="bankDto")
    @Mapping(target = "company", source = "company")
    @Mapping(target = "animals", source = "animals")
    Sponsor toEntity(SponsorDto sponsorDto);

    List<SponsorDto> toDtoList(List<Sponsor> sponsorList);
}
