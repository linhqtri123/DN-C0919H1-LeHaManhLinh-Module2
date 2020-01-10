package com.example.casestudy.service;


import com.example.casestudy.model.FuramaHopDong;

public interface HopDongService {
    public Iterable<FuramaHopDong> getAllHopDong();

    public FuramaHopDong getHopDong(Long idHopDong);

    public void saveHopDong(FuramaHopDong furamaHopDong);

    public void deleteHopDong(Long idHopDong);

    public Iterable<FuramaHopDong> findAllByIdKhachHang(Long idKhachHang);
}
