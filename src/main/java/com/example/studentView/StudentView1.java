package com.example.studentView;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/studentview")
public class StudentView1 extends VerticalLayout {
    public StudentView1(StudentService1 service){
        Grid<com.example.student.Student> grid = new Grid<>(com.example.student.Student.class);
        grid.setItems(service.findAll());

        grid.setColumnOrder(
                // Columns keys are the exact property names of the bean class
                grid.getColumnByKey("name"),
                grid.getColumnByKey("srn"),
                grid.getColumnByKey("team_id"),
                grid.getColumnByKey("email"),
                grid.getColumnByKey("review1"),
                grid.getColumnByKey("review2"),
                grid.getColumnByKey("review3")
        );

        add(grid);
        setSizeFull();
    }
}
