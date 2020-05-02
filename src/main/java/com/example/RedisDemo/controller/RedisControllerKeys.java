package com.example.RedisDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
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

    @RequestMapping(value = "/keys/{key}", method = RequestMethod.GET)
    public Set<Object> showAllHashKeys(@PathVariable String key){
        return redisTemplate.opsForHash().keys(key);
    }

    @RequestMapping(value = "/values/{key}", method = RequestMethod.GET)
    public List<Object> showAllHashValues(@PathVariable String key){
        return redisTemplate.opsForHash().values(key);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Map<Object, Object> hGetAll(@PathVariable String key){
        return redisTemplate.opsForHash().entries(key);
    }

    @RequestMapping(value = "/{key}/size", method = RequestMethod.GET)
    public Long hLen(@PathVariable String key){
        return redisTemplate.opsForHash().size(key);
    }


}
