package com.sanpham.model;

public class Product {
    int id;
    String nameProduct;
    String dateDeliver;
    String addressDeliver;

    public Product() {
    }

    public Product(int id, String nameProduct, String dateDeliver, String addressDeliver) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.dateDeliver = dateDeliver;
        this.addressDeliver = addressDeliver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDateDeliver() {
        return dateDeliver;
    }

    public void setDateDeliver(String dateDeliver) {
        this.dateDeliver = dateDeliver;
    }

    public String getAddressDeliver() {
        return addressDeliver;
    }

    public void setAddressDeliver(String addressDeliver) {
        this.addressDeliver = addressDeliver;
    }
}
