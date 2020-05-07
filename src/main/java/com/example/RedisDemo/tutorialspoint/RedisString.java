package com.example.RedisDemo.tutorialspoint;

import redis.clients.jedis.Jedis;

public class RedisString {

    public static void main(String[] args) {


        Jedis jedis = new Jedis();
        String key = "tutorial-name";
        String value = "Redis tutorial";
        jedis.set(key,value);
        System.out.println("String value : " + jedis.get(key));
        String substring = jedis.getrange(key, 0, 3);
        System.out.println("Substring Redis tutorial:"+ substring);
        System.out.println(jedis.getSet(key,"text"));
        System.out.println("mget: "+jedis.mget(key));
        System.out.println("strlen:"+jedis.strlen(key));
        System.out.println("setnx"+jedis.setnx(key+1,"text2"));
        System.out.println("KEYS");

        jedis.setex(key,60,value);
        jedis.mset(key,value,"text123","sdsd");
        jedis.mget(key,"text123");
        jedis.keys("*").forEach(System.out::println);



    }
}
