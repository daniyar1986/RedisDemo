package com.example.RedisDemo.service.impl;

import com.example.RedisDemo.model.Student;
import com.example.RedisDemo.repository.StudentRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService implements StudentRepository {

    private static final String TABLE_NAME="Student";
    private RedisTemplate redisTemplate;
    private HashOperations<String, Long, Student> hashOperations;

    public StudentService(RedisTemplate<String, Object> redisTemplate3){
        this.redisTemplate = redisTemplate3;
    }

    @PostConstruct
    private void initializeHashOperations(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Student student) {
        hashOperations.put(TABLE_NAME,student.getId(), student);
    }

    @Override
    public Student find(Long id) {
        return hashOperations.get(TABLE_NAME, id);
    }
}
