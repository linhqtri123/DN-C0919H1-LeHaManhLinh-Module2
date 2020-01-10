package com.example.casestudy.repository;

import com.example.casestudy.model.FuramaKhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends CrudRepository<FuramaKhachHang, Long> {
}
