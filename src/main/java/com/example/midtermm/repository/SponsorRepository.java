package com.example.midtermm.repository;

import com.example.midtermm.entity.Animals;
import com.example.midtermm.entity.Company;
import com.example.midtermm.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    List<Sponsor> findByCompany(Company company);
    List<Sponsor> findAllByAnimalsContaining(Animals animal);
}
