package com.example.student;

import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class StudentService implements CrudListener<Student> {
    @Autowired
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student add(Student student) {
        return repository.insert(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }
}
//    public double getAverageSumOfColumns(String collectionName, String[] columnNames) {
//        // Connect to the MongoDB database and retrieve the specified collection
//        MongoCollection<Document> collection = getMongoDatabase().getCollection(collectionName);
//
//        // Initialize variables for storing the total sum and the number of rows processed
//        double totalSum = 0;
//        int numRows = 0;
//
//        // Iterate over the rows in the table
//        for (Document row : collection.find()) {
//            double rowSum = 0;
//
//            // Calculate the sum of columns for the current row
//            for (String columnName : columnNames) {
//                rowSum += row.getDouble(columnName);
//            }
//
//            // Add the row sum to the total sum and increment the number of rows processed
//            totalSum += rowSum;
//            numRows++;
//        }
//
//        // Calculate the average of the sum of columns for every row in the table
//        double average = totalSum / numRows;
//
//        return average;
//    }
//
//
//    // Method to calculate the average of sum of last three rows in faculty collection
//    public double calculateAverageOfLastThreeRows() {
//        List<Student> facultyList = StudentRepository.findTop3ByOrderByIdDesc();
//        double sum = 0;
//        for (Student faculty : facultyList) {
//            sum += (Student.getmarks1() + Student.getmarks2()+Student.getmarks);
//        }
//        return sum / 3;
//    }
