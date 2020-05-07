package com.example.RedisDemo.tutorialspoint;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisHashes {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        String key = "tutorialspoint";

        Map<String, String >  hashMap = new HashMap<>();
        hashMap.put("name","redis tutorial");
        hashMap.put("description","redis basic commands for caching");
        hashMap.put("likes", String.valueOf(20));
        hashMap.put("visitors", String.valueOf(23000));
        jedis.hset(key, hashMap);
    }
}
