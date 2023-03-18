package com.codegym.ben_xe.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;


@Entity
public class BenXe implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "không được để khoảng trống")
    private String soXe;

    @NotBlank(message = "không được để khoảng trống")
    @Pattern(regexp = "^(090|093|097)\\d{7}$",message = "Số điẹn thoại không đúng định dạng")
    private String soDienThoai;
    @NotBlank(message = "không được để khoảng trống")
    @Email(message = "Email phải đúng định dạng")
    private String email;
    @NotBlank(message = "không được để khoảng trống")
    private String gioDi;
    @NotBlank(message = "không được để khoảng trống")
    private String gioDen;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BenXe benXe = (BenXe) target;
        String gioDies = benXe.getGioDi();

        if (false){
            errors.rejectValue("dateOfBirth", "dateOfBirth","ngày sinh không đúng, bạn phải " +
                    "lớn hơn 18 tuổi và nhỏ hơn 90 tuổi");
        }
    }

    @NotBlank(message = "không được để khoảng trống")
    @ManyToOne
    @JoinColumn(name = "laoiXeId",referencedColumnName = "id")
    private LoaiXe  loaiXe;
    @NotBlank(message = "không được để khoảng trống")
    @ManyToOne
    @JoinColumn(name = "nhaXeId",referencedColumnName = "id")
    private NhaXe nhaXe;
    @NotBlank(message = "không được để khoảng trống")
    @ManyToOne
    @JoinColumn(name = "diemDiId",referencedColumnName = "id")
    private  DiaDiem diemDi;
    @NotBlank(message = "không được để khoảng trống")
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
