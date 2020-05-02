package com.example.RedisDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/redis")
public class RedisControllerKeys {

    private HashOperations hashOperations;
    private ListOperations listOperations;
    private SetOperations setOperations;
    private RedisTemplate<String, Object> redisTemplate;

    public RedisControllerKeys(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
        listOperations = redisTemplate.opsForList();
        setOperations = redisTemplate.opsForSet();
    }

    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    public Set<String> showAllKeys(){
        return redisTemplate.keys("*");
    }

    @RequestMapping(value = "/keys/{key}", method = RequestMethod.GET)
    public Set<Object> showAllHashKeys(@PathVariable String key){
        return hashOperations.keys(key);
    }

    @RequestMapping(value = "/values/{key}", method = RequestMethod.GET)
    public List<Object> showAllHashValues(@PathVariable String key){
        return hashOperations.values(key);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Map<Object, Object> hGetAll(@PathVariable String key){
        return redisTemplate.opsForHash().entries(key);
    }

    @RequestMapping(value = "/{key}/size", method = RequestMethod.GET)
    public Long hLen(@PathVariable String key){
        return redisTemplate.opsForHash().size(key);
    }

    public String listSort(){
        //lpush num 1 2 3 4
        listOperations.leftPushAll("num",1,2,3,4);

        //delete 4 from pop
        listOperations.leftPop("num");

        //show all list
        listOperations.range("num",0,-1);

        return "Example";
    }

}
