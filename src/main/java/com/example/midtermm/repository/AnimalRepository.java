package com.example.midtermm.repository;

import com.example.midtermm.entity.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animals,Long> {
}
