package com.example.exam.repository;

import com.example.exam.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Iterable<Book> findAllById(Long id);
    Iterable<Book> findAllByBookName(String name);
}
