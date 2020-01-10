package com.example.casestudy.service.impl;

import com.example.casestudy.model.FuramaHopDong;
import com.example.casestudy.repository.HopDongRepository;
import com.example.casestudy.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    private HopDongRepository hopDongRepository;

    @Override
    public Iterable<FuramaHopDong> getAllHopDong() {
        return hopDongRepository.findAll();
    }

    @Override
    public FuramaHopDong getHopDong(Long idHopDong) {
        return hopDongRepository.findById(idHopDong).orElse(null);
    }

    @Override
    public void saveHopDong(FuramaHopDong furamaHopDong) {
        hopDongRepository.save(furamaHopDong);
    }

    @Override
    public void deleteHopDong(Long idHopDong) {
        hopDongRepository.deleteById(idHopDong);
    }

    @Override
    public Iterable<FuramaHopDong> findAllByIdKhachHang(Long idKhachHang) {
        return hopDongRepository.findAllByIdKhachHang(idKhachHang);
    }
}
