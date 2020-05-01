package com.example.RedisDemo.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String productPrice;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}
