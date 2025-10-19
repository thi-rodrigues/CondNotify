package com.trsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trsystems.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Long>{

}
