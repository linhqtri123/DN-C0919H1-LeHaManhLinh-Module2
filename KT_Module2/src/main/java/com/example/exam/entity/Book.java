package com.example.exam.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter Name !!!")
    @Size(max = 30, message = "Enter name not over 30 character !!!")
    private String bookName;
    @NotEmpty(message = "Enter Author !!!")
    @Size(max = 30, message = "Enter author not over 30 character !!!")
    private String author;
    @NotEmpty(message = "Enter price !!!")
    @Range(min=10000,message = "Enter price not less then 10000 !!!")
    private String price;

    public Book() {
    }

    public Book(String bookName, String author, String price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
