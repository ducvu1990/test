package com.codegym.ben_xe.service.impl;

import com.codegym.ben_xe.model.DiaDiem;
import com.codegym.ben_xe.repository.IDiaDiemRepository;
import com.codegym.ben_xe.service.IDiaDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiaDiemService implements IDiaDiemService {
    @Autowired
    private IDiaDiemRepository diaDiemRepository;
    @Override
    public List<DiaDiem> getAllDiaDiem() {
        return this.diaDiemRepository.findAll();
    }
}
