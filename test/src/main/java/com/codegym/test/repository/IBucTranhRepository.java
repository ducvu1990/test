package com.codegym.test.repository;

import com.codegym.test.model.BucTranh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBucTranhRepository extends JpaRepository<BucTranh,Integer> {
    Page<BucTranh> findBucTranhByTenContains(String ten, Pageable pageable);
}
