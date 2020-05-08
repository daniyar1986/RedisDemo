package com.example.RedisDemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
}
