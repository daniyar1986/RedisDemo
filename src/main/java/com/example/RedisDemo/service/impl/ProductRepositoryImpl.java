package com.example.RedisDemo.service.impl;

import com.example.RedisDemo.model.Product;
import com.example.RedisDemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final String REDIS_INDEX_KEY2 = "PRODUCTS2";

    private RedisTemplate<String, Product> redisTemplate2;
    private HashOperations hashOperations;

    public ProductRepositoryImpl(RedisTemplate<String, Product> redisTemplate2) {
        this.redisTemplate2 = redisTemplate2;
        hashOperations = redisTemplate2.opsForHash();
    }

    @Override
    public void save(Product product) {
        hashOperations.put(REDIS_INDEX_KEY2, product.getProductId(), product);
    }

    @Override
    public Map<String, Product> findAll() {
        return hashOperations.entries(REDIS_INDEX_KEY2);
    }

    @Override
    public void update(Product product) {
        save(product);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(REDIS_INDEX_KEY2, id);
    }

    @Override
    public Product findById(String id) {
        return (Product) hashOperations.get(REDIS_INDEX_KEY2, id);
    }
}
