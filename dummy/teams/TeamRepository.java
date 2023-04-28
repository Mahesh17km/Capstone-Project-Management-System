package com.example.teams;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TeamRepository extends MongoRepository<Team,Integer> {
}
