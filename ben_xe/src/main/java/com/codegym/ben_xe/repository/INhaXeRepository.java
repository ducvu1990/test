package com.codegym.ben_xe.repository;

import com.codegym.ben_xe.model.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhaXeRepository extends JpaRepository<NhaXe, Integer> {
}
