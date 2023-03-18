package com.codegym.ben_xe.service;

import com.codegym.ben_xe.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBenXeService {
    Page<BenXe> getAll(String soXe, Pageable pageable);

    boolean save(BenXe benXe);
    BenXe findBenXeById(int id);
    BenXe findBenXeBySoXe(String soXe);
    boolean update(int id, BenXe benXe);
    boolean remove(int id);
    Page<BenXe> sortDESC(Pageable pageable);
    Page<BenXe> sortASC(Pageable pageable);
}
