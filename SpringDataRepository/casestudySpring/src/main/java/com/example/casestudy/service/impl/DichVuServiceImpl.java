package com.example.casestudy.service.impl;

import com.example.casestudy.model.FuramaDichVu;
import com.example.casestudy.repository.DichVuRepository;
import com.example.casestudy.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;

    @Override
    public Iterable<FuramaDichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }

    @Override
    public Optional<FuramaDichVu> getDichVu(Long idDichVu) {
        return dichVuRepository.findById(idDichVu);
    }

    @Override
    public void saveDichVu(FuramaDichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    @Override
    public void deleteDichVu(Long idDichVu) {
        dichVuRepository.deleteById(idDichVu);
    }

    @Override
    public Iterable<FuramaDichVu> findAllByChiPhiThueBetween(String formPrice, String toPrice) {
        return dichVuRepository.findAllByChiPhiThueBetween(formPrice,toPrice);
    }
}
