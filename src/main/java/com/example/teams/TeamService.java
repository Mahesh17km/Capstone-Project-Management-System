package com.example.teams;


import com.example.student.Student;
import com.example.student.StudentRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Repository
public class TeamService implements CrudListener<Team> {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Team add(Team teams) {
        return repository.insert(teams);
    }

    @Override
    public Team update(Team teams) { return repository.insert(teams); }

    @Override
    public void delete(Team teams) {
        repository.delete(teams);
        //repository.deleteAll();
    }
}