package com.codegym.ben_xe.service.impl;

import com.codegym.ben_xe.model.LoaiXe;
import com.codegym.ben_xe.repository.ILoaiXeRepository;
import com.codegym.ben_xe.service.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService implements ILoaiXeService {
    @Autowired
    private ILoaiXeRepository loaiXeRepository;
    @Override
    public List<LoaiXe> getAllLoaiXe() {
        return this.loaiXeRepository.findAll();
    }
}
