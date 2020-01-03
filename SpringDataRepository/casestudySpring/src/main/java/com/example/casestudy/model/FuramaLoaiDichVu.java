package com.example.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaidichvu")
public class FuramaLoaiDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tendichvu")
    private String tenDichVu;

    @OneToMany(targetEntity = FuramaDichVu.class)
    private List<FuramaDichVu> furamaDichVu;

    public FuramaLoaiDichVu() {
    }

    public FuramaLoaiDichVu(String tenDichVu, List<FuramaDichVu> furamaDichVu) {
        this.tenDichVu = tenDichVu;
        this.furamaDichVu = furamaDichVu;
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

    public List<FuramaDichVu> getFuramaDichVu() {
        return furamaDichVu;
    }

    public void setFuramaDichVu(List<FuramaDichVu> furamaDichVu) {
        this.furamaDichVu = furamaDichVu;
    }
}
