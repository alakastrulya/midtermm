package com.example.mid.repository;

import com.example.mid.entity.Animals;
import com.example.mid.entity.Company;
import com.example.mid.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    List<Sponsor> findByCompany(Company company);
    List<Sponsor> findAllByAnimalsContaining(Animals animal);
}
