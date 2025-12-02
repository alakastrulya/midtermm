package com.example.mid.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalsDto {
    private Long id;
    private String name;
    private String type;
    private int age;
}
