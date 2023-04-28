package com.example.student;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
@Route("/students")
public class StudentView extends VerticalLayout {
    public StudentView(StudentService service){
        GridCrud<Student> crud = new GridCrud<>(Student.class, service);
        add(crud);
        Grid<Student> grid = crud.getGrid();
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
        setSizeFull();
    }
}
