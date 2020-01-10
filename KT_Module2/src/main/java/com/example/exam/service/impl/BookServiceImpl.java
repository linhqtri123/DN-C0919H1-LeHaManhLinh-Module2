package com.example.exam.service.impl;

import com.example.exam.entity.Book;
import com.example.exam.repository.BookRepository;
import com.example.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Iterable<Book> findAllById(Long id) {
        return bookRepository.findAllById(id);
    }

    @Override
    public Iterable<Book> findAllByBookName(String name) {
        return bookRepository.findAllByBookName(name);
    }

}
