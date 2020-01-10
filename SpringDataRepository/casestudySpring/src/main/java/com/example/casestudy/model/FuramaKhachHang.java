package com.example.casestudy.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "khachhang")
public class FuramaKhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkhachhang")
    private Long id;

    @Column(name = "idloaikhach")
    private Long idLoaiKhach;

    @NotEmpty(message = "Enter Name !!!")
    @Column(name = "hoten")
    private String hoTen;

    @NotNull(message = "Enter Birthday !!!")
    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",message = "Must have 9 or 12 number" )
    @NotEmpty(message = "Enter Id Card !!!")
    @Column(name = "socmtnd")
    private String soCMND;

    @Pattern(regexp = "^([0-9]{10})$",message = "Must right phone number")
    @NotEmpty(message = "Enter Number Phone !!!")
    @Column(name = "sdt")
    private String sdt;

    @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$",message = "Validation Email !!")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Enter Address !!!")
    @Column(name = "diachi")
    private String diaChi;

    public FuramaKhachHang() {
    }

    public FuramaKhachHang(Long idLoaiKhach, String hoTen, Date ngaySinh, String soCMND, String sdt, String email, String diaChi) {
        this.idLoaiKhach = idLoaiKhach;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLoaiKhach() {
        return idLoaiKhach;
    }

    public void setIdLoaiKhach(Long idLoaiKhach) {
        this.idLoaiKhach = idLoaiKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
