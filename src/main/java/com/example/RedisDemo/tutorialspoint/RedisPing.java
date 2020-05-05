package com.example.RedisDemo.tutorialspoint;

import redis.clients.jedis.Jedis;

public class RedisPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Server is running "+jedis.ping());
        System.out.println("Server is running "+jedis.ping("Ping test"));
    }
}
