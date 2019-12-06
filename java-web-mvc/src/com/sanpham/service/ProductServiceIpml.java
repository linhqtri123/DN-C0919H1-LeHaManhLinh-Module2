package com.sanpham.service;

import com.sanpham.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIpml implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "xemay", "16/10/2019", "32 Nguyễn Văn Linh"));
        products.put(2, new Product(2, "xemay", "1/11/2019", "33 Lê Hiến Mai"));
        products.put(3, new Product(3, "Sách Đạo Đức 10", "2/3/2019", "Quảng Nam"));
        products.put(4, new Product(4, "Nước Ngọt", "1/10/2019", "Đà Nẵng"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String nameProduct) {
        Map<Integer, Product> products2 = new HashMap<>();
        int id;
        for (Product p : products.values()) {
            if (p.getNameProduct().equals(nameProduct)) {

                products2.put(p.getId(),p);
            }
        }
        return new ArrayList<>(products2.values());
    }
    @Override
    public Product findByName2(String nameProduct) {
        int id = 1;
        for (Product p : products.values()) {
            if (p.getNameProduct().equals(nameProduct)) {
                id = p.getId();
            }
        }
        return products.get(id);
    }
        @Override
        public void update ( int id, Product product){
            products.put(id, product);
        }

        @Override
        public void remove ( int id){
            products.remove(id);
        }
    }
