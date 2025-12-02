package com.example.mid.repository;

import com.example.mid.entity.Animals;
import com.example.mid.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
