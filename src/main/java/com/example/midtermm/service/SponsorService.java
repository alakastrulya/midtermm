package com.example.midtermm.service;

import com.example.midtermm.dto.SponsorDto;

import java.util.List;

public interface SponsorService {
    List<SponsorDto> getAll();
    SponsorDto getById(Long id);
    SponsorDto addSponsor(SponsorDto sponsorDto);
    SponsorDto updateSponsor(Long id,SponsorDto sponsorDto);
    boolean deleteSponsor(Long id);
}
