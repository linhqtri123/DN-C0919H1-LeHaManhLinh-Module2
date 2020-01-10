package com.example.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "dichvu")
public class FuramaDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tendichvu")
    private String tenDichVu;

    @Column(name = "dientich")
    private int dienTich;

    @Column(name = "sotang")
    private int soTang;

    @Column(name = "songuoitoida")
    private int soNguoiToiDa;

    @Column(name = "chiphithue")
    private String chiPhiThue;

    @Column(name = "trangthai")
    private String trangThai;

    @Column(name = "kieuthue_id")
    private Long kieuthue_id;

    @ManyToOne
    @JoinColumn(name = "loaidichvu_id")
    private FuramaLoaiDichVu furamaLoaiDichVu;

    public FuramaDichVu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(String chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Long getKieuthue_id() {
        return kieuthue_id;
    }

    public void setKieuthue_id(Long kieuthue_id) {
        this.kieuthue_id = kieuthue_id;
    }

    public FuramaLoaiDichVu getFuramaLoaiDichVu() {
        return furamaLoaiDichVu;
    }

    public void setFuramaLoaiDichVu(FuramaLoaiDichVu furamaLoaiDichVu) {
        this.furamaLoaiDichVu = furamaLoaiDichVu;
    }
}
