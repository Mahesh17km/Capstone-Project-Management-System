package com.example.studentView;

import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Repository
public class StudentService1{
    private final StudentRepository1 repository;
    public StudentService1(StudentRepository1 repository) {
        this.repository = repository;
    }

    public List<com.example.student.Student> findAll() {
        return repository.findAll();
    }
}