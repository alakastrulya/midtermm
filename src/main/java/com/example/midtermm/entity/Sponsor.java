package com.example.midtermm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "t_sponsor")
@Builder
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bank;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "t_company_id",nullable = true)
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_sponsor_animals",
            joinColumns = @JoinColumn(name = "sponsor_id"),
            inverseJoinColumns = @JoinColumn(name = "animals_id")
    )
    List<Animals> animals;
}
