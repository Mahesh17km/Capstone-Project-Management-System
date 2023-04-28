package com.example.faculty;

import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Repository
public class FacultyService implements CrudListener<Faculty> {
    private final FacultyRepository repository;
    public FacultyService(FacultyRepository repository) {this.repository = repository;}
    @Override
    public List<Faculty> findAll() {return repository.findAll();}
    @Override
    public Faculty add(Faculty faculty) {return repository.insert(faculty);}
    @Override
    public Faculty update(Faculty faculty) {return repository.save(faculty);}
    @Override
    public void delete(Faculty faculty) {repository.delete(faculty);}
}