package com.example.project;

import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Repository
public class CapstoneService implements CrudListener<Capstone> {
    private final CapstoneRepository repository;
    public CapstoneService(CapstoneRepository repository) {this.repository = repository;}
    @Override
    public List<Capstone> findAll() {return repository.findAll();}
    @Override
    public Capstone add(Capstone capstone) {return repository.insert(capstone);}
    @Override
    public Capstone update(Capstone capstone) {return repository.save(capstone);}
    @Override
    public void delete(Capstone capstone) {repository.deleteById(capstone.getId());}
}