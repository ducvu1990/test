package com.codegym.ben_xe.repository;

import com.codegym.ben_xe.model.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoaiXeRepository extends JpaRepository<LoaiXe,Integer> {
}
