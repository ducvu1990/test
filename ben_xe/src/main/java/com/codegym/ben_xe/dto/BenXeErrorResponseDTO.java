package com.codegym.ben_xe.dto;

public class BenXeErrorResponseDTO {

    private String soXe;

    private String soDienThoai;

    private String email;

    private String gioDi;

    private String gioDen;

    public BenXeErrorResponseDTO(String soXe, String soDienThoai, String email, String gioDi, String gioDen) {
        this.soXe = soXe;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
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
}
