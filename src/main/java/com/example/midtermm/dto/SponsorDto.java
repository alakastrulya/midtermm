package com.example.midtermm.dto;

import lombok.*;


import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SponsorDto {
    private Long idDto;
    private String nameDto;
    private String bankDto;
    private CompanyDto company;
    List<AnimalsDto> animals;
}
