package com.codegym.ben_xe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String soXe;
    private String soDienThoai;
    private String email;
    private String gioDi;
    private String gioDen;
    @ManyToOne
    @JoinColumn(name = "laoiXeId",referencedColumnName = "id")
    private LoaiXe  loaiXe;
    @ManyToOne
    @JoinColumn(name = "nhaXeId",referencedColumnName = "id")
    private NhaXe nhaXe;
    @ManyToOne
    @JoinColumn(name = "diemDiId",referencedColumnName = "id")
    private  DiaDiem diemDi;
    @ManyToOne
    @JoinColumn(name = "diemDenId",referencedColumnName = "id")
    private DiaDiem diemDen;

    public BenXe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioDi() {
        return gioDi;
    }

    public void setGioDi(String gioDi) {
        this.gioDi = gioDi;
    }

    public String getGioDen() {
        return gioDen;
    }

    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }

    public DiaDiem getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(DiaDiem diemDi) {
        this.diemDi = diemDi;
    }

    public DiaDiem getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(DiaDiem diemDen) {
        this.diemDen = diemDen;
    }
}
