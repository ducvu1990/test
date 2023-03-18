package com.codegym.ben_xe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DiaDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenDiaDiem;
    @JsonIgnore
    @OneToMany(mappedBy = "diemDi", cascade = CascadeType.ALL)
    private Set<BenXe> benXe;
    @JsonIgnore
    @OneToMany(mappedBy = "diemDen", cascade = CascadeType.ALL)
    private Set<BenXe> benXe1;

    public DiaDiem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public Set<BenXe> getBenXe() {
        return benXe;
    }

    public void setBenXe(Set<BenXe> benXe) {
        this.benXe = benXe;
    }

    public Set<BenXe> getBenXe1() {
        return benXe1;
    }

    public void setBenXe1(Set<BenXe> benXe1) {
        this.benXe1 = benXe1;
    }
}
