package com.codegym.ben_xe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenLoaiXe;
    @JsonIgnore
    @OneToMany(mappedBy = "loaiXe", cascade = CascadeType.ALL)
    private Set<BenXe> benXe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    public Set<BenXe> getBenXe() {
        return benXe;
    }

    public void setBenXe(Set<BenXe> benXe) {
        this.benXe = benXe;
    }
}
