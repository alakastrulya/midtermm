package com.example.midtermm.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private int age;
    private Long quantityOfAnimals;
}
