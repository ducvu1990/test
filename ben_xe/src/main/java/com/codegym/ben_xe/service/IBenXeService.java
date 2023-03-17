package com.codegym.ben_xe.service;

import com.codegym.ben_xe.model.BenXe;

import java.util.List;

public interface IBenXeService {
    List<BenXe> getAll();

    boolean save(BenXe benXe);
    BenXe findBenXeById(int id);
    BenXe findBenXeBySoXe(String soXe);
    boolean update(int id, BenXe benXe);
    boolean remove(int id);
}
