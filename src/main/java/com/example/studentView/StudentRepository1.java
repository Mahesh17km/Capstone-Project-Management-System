package com.example.studentView;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository1 extends MongoRepository<com.example.student.Student,Integer> {
}
