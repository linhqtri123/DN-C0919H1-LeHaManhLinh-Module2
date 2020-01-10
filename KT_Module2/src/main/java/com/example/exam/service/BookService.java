package com.example.exam.service;

import com.example.exam.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);
    Iterable<Book> findAllById(Long id);
    Iterable<Book> findAllByBookName(String name);
}
