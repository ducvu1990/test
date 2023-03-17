package com.codegym.ben_xe.service.impl;

import com.codegym.ben_xe.model.NhaXe;
import com.codegym.ben_xe.repository.INhaXeRepository;
import com.codegym.ben_xe.service.INhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXeService implements INhaXeService {
    @Autowired
    private INhaXeRepository nhaXeRepository;
    @Override
    public List<NhaXe> getAllNhaXe() {
        return this.nhaXeRepository.findAll();
    }
}
