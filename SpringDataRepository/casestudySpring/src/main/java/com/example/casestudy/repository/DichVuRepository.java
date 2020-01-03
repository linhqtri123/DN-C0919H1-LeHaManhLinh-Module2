package com.example.casestudy.repository;

import com.example.casestudy.model.FuramaDichVu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends PagingAndSortingRepository<FuramaDichVu,Long> {
}
