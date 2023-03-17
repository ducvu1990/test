package com.codegym.ben_xe.repository;

import com.codegym.ben_xe.model.DiaDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaDiemRepository extends JpaRepository<DiaDiem, Integer> {
}
