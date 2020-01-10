package com.example.casestudy.service.impl;

import com.example.casestudy.model.FuramaKhachHang;
import com.example.casestudy.repository.KhachHangRepository;
import com.example.casestudy.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Iterable<FuramaKhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public FuramaKhachHang getKhachHang(Long idKhachHang) {
        return khachHangRepository.findById(idKhachHang).orElse(null);
    }

    @Override
    public void saveKhachHang(FuramaKhachHang furamaKhachHang) {
        khachHangRepository.save(furamaKhachHang);
    }

    @Override
    public void deleteKhachHang(Long idKhachHang) {
        khachHangRepository.deleteById(idKhachHang);
    }
}
