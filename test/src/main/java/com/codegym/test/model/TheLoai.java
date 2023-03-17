package com.codegym.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTheLoai;

    @OneToMany(mappedBy = "theLoai")
    private Set<BucTranh> bucTranhSet;

    public TheLoai() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Set<BucTranh> getBucTranhSet() {
        return bucTranhSet;
    }

    public void setBucTranhSet(Set<BucTranh> bucTranhSet) {
        this.bucTranhSet = bucTranhSet;
    }
}
