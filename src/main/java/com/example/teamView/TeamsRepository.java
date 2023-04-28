package com.example.teamView;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TeamsRepository extends MongoRepository<com.example.project.Capstone,Integer> {
}
