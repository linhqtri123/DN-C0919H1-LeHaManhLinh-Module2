package com.example.quanlytinh.repository;

import com.example.quanlytinh.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}