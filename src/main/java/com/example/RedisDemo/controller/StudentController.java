package com.example.RedisDemo.controller;

import com.example.RedisDemo.model.Student;
import com.example.RedisDemo.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student")
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @Cacheable(key = "#id", value = "students", unless = "#result.id < 1200")
    @GetMapping("/student/{id}")
    public Student fetchStudent(@PathVariable("id") Long id){
        return studentService.find(id);
    }
}
