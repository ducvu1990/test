package com.codegym.test.service.impl;

import com.codegym.test.model.TheLoai;
import com.codegym.test.repository.ITheLoaiRepository;
import com.codegym.test.service.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiService implements ITheLoaiService {
    @Autowired
    private ITheLoaiRepository theLoaiRepository;
    @Override
    public List<TheLoai> showAll() {
        return theLoaiRepository.findAll();
    }
}
