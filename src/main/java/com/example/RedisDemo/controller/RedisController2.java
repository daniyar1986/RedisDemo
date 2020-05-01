package com.example.RedisDemo.controller;

import com.example.RedisDemo.model.Product;
import com.example.RedisDemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RedisController2 {


    private final ProductRepository productRepository;

    @RequestMapping(value = "/products2", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Product is saved successfully";
    }

    @RequestMapping(value = "/products2", method = RequestMethod.GET)
    public Map<String, Product> getProducts(){
        Map<String, Product> entries = productRepository.findAll();
        return entries;
    }

    @RequestMapping(value = "/products2/{productId}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("productId") String productId, @RequestBody Product product){
        productRepository.update(product);
        return "Product is updated successfully";
    }

    @RequestMapping(value = "/products2/{productId}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable String productId){
        productRepository.delete(productId);
        return "Product successfully deleted";
    }

    @RequestMapping(value = "/products2/{productId}", method = RequestMethod.GET)
    public Object getProductById(@PathVariable String productId){
        return productRepository.findById(productId);
    }
}
