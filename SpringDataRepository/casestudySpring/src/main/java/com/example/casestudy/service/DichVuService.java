package com.example.casestudy.service;

import com.example.casestudy.model.FuramaDichVu;

import java.util.Optional;

public interface DichVuService {

    public Iterable<FuramaDichVu> getAllDichVu();

    public Optional<FuramaDichVu> getDichVu(Long idDichVu);

    public void saveDichVu(FuramaDichVu dichVu);

    public void deleteDichVu(Long idDichVu);

    public Iterable<FuramaDichVu> findAllByChiPhiThueBetween(String formPrice, String toPrice);

}
