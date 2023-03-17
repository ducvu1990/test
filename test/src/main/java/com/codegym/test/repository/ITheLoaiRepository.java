package com.codegym.test.repository;

import com.codegym.test.model.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITheLoaiRepository extends JpaRepository<TheLoai,Integer> {
}
