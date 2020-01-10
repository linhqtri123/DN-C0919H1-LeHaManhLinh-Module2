package com.example.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "hopdong")
public class FuramaHopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhopdong")
    private Long id;

    @Column(name = "idnhanvien")
    private Long idNhanVien;

    @Column(name = "idkhachhang")
    private Long idKhachHang;

    @Column(name = "ngaylamhopdong")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayLamHopDong;

    @Column(name = "ngayketthuc")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayKetThuc;

    @Column(name = "tiendatcoc")
    private double tienDatCoc;

    @Column(name = "tongtien")
    private double tongTien;

    @Column(name = "iddichvu")
    private  Long idDichVu;

    public FuramaHopDong() {
    }

    public FuramaHopDong(Long idNhanVien, Long idKhachHang, Date ngayLamHopDong, Date ngayKetThuc, double tienDatCoc, double tongTien, Long idDichVu) {
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.tongTien = tongTien;
        this.idDichVu = idDichVu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Long getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Long idDichVu) {
        this.idDichVu = idDichVu;
    }

    public FuramaHopDong(Long idNhanVien, Long idKhachHang, Date ngayLamHopDong, Date ngayKetThuc, double tienDatCoc) {
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.tienDatCoc = tienDatCoc;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(Date ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }
}
