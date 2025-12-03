package com.example.midtermm.repository;

import com.example.midtermm.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRep extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}