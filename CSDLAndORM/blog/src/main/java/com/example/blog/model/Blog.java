package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameBlog;
    private String quickView;
    private String content;

    public Blog() {
    }

    public Blog(String nameBlog, String quickView, String content) {
        this.nameBlog = nameBlog;
        this.quickView = quickView;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getQuickView() {
        return quickView;
    }

    public void setQuickView(String quickView) {
        this.quickView = quickView;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
