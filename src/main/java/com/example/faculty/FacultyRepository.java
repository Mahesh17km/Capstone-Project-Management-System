package com.example.faculty;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface FacultyRepository extends MongoRepository<Faculty,Integer> {
}
