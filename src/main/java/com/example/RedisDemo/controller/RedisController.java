package com.example.RedisDemo.controller;

import com.example.RedisDemo.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private static final String REDIS_INDEX_KEY = "PRODUCTS";

    private final RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        redisTemplate.opsForHash().put(REDIS_INDEX_KEY,
                product.getProductId(), product.toString());
        return "Product is saved successfully";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(REDIS_INDEX_KEY);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("productId") String productId, @RequestBody Product product){
        redisTemplate.opsForHash().put(REDIS_INDEX_KEY, product.getProductId(),product.toString());

        return "Product is updated successfully";
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable String productId){
        redisTemplate.opsForHash().delete(REDIS_INDEX_KEY, productId);
        return "Product successfully deleted";
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Object getProductById(@PathVariable String productId){
        return redisTemplate.opsForHash().get(REDIS_INDEX_KEY, productId);
    }
}
