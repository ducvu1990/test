package com.codegym.ben_xe.repository;

import com.codegym.ben_xe.model.BenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBenXeRepository extends JpaRepository<BenXe, Integer> {
    BenXe findBenXeBySoXe(String soXe);
}
