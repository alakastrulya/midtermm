package com.example.mid.service;

import com.example.mid.dto.CompanyDto;
import com.example.mid.dto.SponsorDto;

import java.util.List;

public interface SponsorService {
    List<SponsorDto> getAll();
    SponsorDto getById(Long id);
    SponsorDto addSponsor(SponsorDto sponsorDto);
    SponsorDto updateSponsor(Long id,SponsorDto sponsorDto);
    boolean deleteSponsor(Long id);
}
