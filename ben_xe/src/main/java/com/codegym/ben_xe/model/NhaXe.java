package com.codegym.ben_xe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NhaXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenNhaXe;
    @JsonIgnore
    @OneToMany(mappedBy = "nhaXe", cascade = CascadeType.ALL)
    private Set<BenXe> benXe;

    public NhaXe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public Set<BenXe> getBenXe() {
        return benXe;
    }

    public void setBenXe(Set<BenXe> benXe) {
        this.benXe = benXe;
    }
}
