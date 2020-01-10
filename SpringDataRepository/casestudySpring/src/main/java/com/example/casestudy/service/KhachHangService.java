package com.example.casestudy.service;


import com.example.casestudy.model.FuramaKhachHang;

public interface KhachHangService {
    public Iterable<FuramaKhachHang> getAllKhachHang();

    public FuramaKhachHang getKhachHang(Long idKhachHang);

    public void saveKhachHang(FuramaKhachHang furamaKhachHang);

    public void deleteKhachHang(Long idKhachHang);

}
