package com.codegym.test.service;

import com.codegym.test.model.BucTranh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBucTranhService {
    Page<BucTranh> findAllAndSearch(String ten, Pageable pageable);
    void remove(int id);
    void save(BucTranh bucTranh);
}
