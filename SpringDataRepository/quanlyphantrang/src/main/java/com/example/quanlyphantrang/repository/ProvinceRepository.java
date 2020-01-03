package com.example.quanlyphantrang.repository;

import com.example.quanlyphantrang.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}