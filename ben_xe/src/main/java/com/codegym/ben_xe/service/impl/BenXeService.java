package com.codegym.ben_xe.service.impl;

import com.codegym.ben_xe.model.BenXe;
import com.codegym.ben_xe.repository.IBenXeRepository;
import com.codegym.ben_xe.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BenXeService implements IBenXeService {
    @Autowired
    private IBenXeRepository benXeRepository;
    @Override
    public List<BenXe> getAll() {
        return this.benXeRepository.findAll();
    }

    @Override
    public boolean save(BenXe benXe) {
        if (this.benXeRepository.findBenXeBySoXe(benXe.getSoXe()) != null){
            return false;
        }
        this.benXeRepository.save(benXe);
        return true;
    }

    @Override
    public BenXe findBenXeById(int id) {
        return this.benXeRepository.findById(id).get();
    }

    @Override
    public BenXe findBenXeBySoXe(String soXe) {
        return this.benXeRepository.findBenXeBySoXe(soXe);
    }

    @Override
    public boolean update(int id, BenXe benXe) {
        if (this.benXeRepository.findById(id).isPresent()){
            this.benXeRepository.save(benXe);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        if (this.benXeRepository.findById(id).isPresent()){
            this.benXeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
