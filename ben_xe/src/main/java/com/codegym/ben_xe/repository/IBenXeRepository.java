package com.codegym.ben_xe.repository;

import com.codegym.ben_xe.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBenXeRepository extends JpaRepository<BenXe, Integer> {
    BenXe findBenXeBySoXe(String soXe);
    @Query(value = "SELECT * FROM busstation.ben_xe where so_xe like %:soXe% order by so_xe", nativeQuery = true)
    Page<BenXe> searchAndSort(@Param("soXe") String soXe, Pageable pageable);
    @Query(value = "SELECT * FROM busstation.ben_xe order by so_xe DESC", nativeQuery = true)
    Page<BenXe> sortDESC(Pageable pageable);
    @Query(value = "SELECT * FROM busstation.ben_xe order by so_xe ASC", nativeQuery = true)
    Page<BenXe> sortASC(Pageable pageable);
}
