package com.example.RedisDemo.repository;

import com.example.RedisDemo.model.Product;

import java.util.Map;

public interface ProductRepository {

    void save(Product product);
    Map<String, Product> findAll();
    void update(Product product);
    void delete(String id);
    Product findById(String id);
}
