package com.codegym.test.service.impl;

import com.codegym.test.model.BucTranh;
import com.codegym.test.repository.IBucTranhRepository;
import com.codegym.test.service.IBucTranhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class BucTranhService implements IBucTranhService {
    @Autowired
    private IBucTranhRepository bucTranhRepository;

    @Override
    public Page<BucTranh> findAllAndSearch(String ten, Pageable pageable) {
        return bucTranhRepository.findBucTranhByTenContains(ten, pageable);
    }

    @Override
    public void remove(int id) {
        bucTranhRepository.deleteById(id);
    }

    @Override
    public void save(BucTranh bucTranh) {
        bucTranhRepository.save(bucTranh);
    }

}
