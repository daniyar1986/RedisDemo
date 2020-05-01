package com.example.RedisDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/redis")
@RequiredArgsConstructor
public class RedisControllerKeys {

    private final RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    public Set<String> showAllKeys(){
        return redisTemplate.keys("*");
    }

}
