package com.example.RedisDemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
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
