package com.example.RedisDemo.repository;

import com.example.RedisDemo.model.Student;

public interface StudentRepository {
    void save(Student student);
    Student find(Long id);
}
