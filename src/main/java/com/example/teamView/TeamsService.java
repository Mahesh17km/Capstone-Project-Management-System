package com.example.teamView;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamsService {
    private final TeamsRepository repository;
    public TeamsService(TeamsRepository repository) {
        this.repository = repository;
    }

    public List<com.example.project.Capstone> findAll() {
        return repository.findAll();
    }
}