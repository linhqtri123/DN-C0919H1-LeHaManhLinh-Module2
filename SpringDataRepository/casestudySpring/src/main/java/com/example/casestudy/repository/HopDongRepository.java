package com.example.casestudy.repository;

import com.example.casestudy.model.FuramaHopDong;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends PagingAndSortingRepository<FuramaHopDong, Long> {
    Iterable<FuramaHopDong> findAllByIdKhachHang(Long id);
}
