package com.example.faculty;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
@Route("/faculty")
public class FacultyView extends VerticalLayout {
    public FacultyView(FacultyService service){
        GridCrud<Faculty> crud = new GridCrud<>(Faculty.class, service);
        add(crud);
        Grid<Faculty> grid = crud.getGrid();
//        grid.setColumnOrder(
//                // Columns keys are the exact property names of the bean class
//                grid.getColumnByKey("name"),
//                grid.getColumnByKey("id"),
//                grid.getColumnByKey("team_id"),
//                grid.getColumnByKey("email"),
//                grid.getColumnByKey("teams")

//        );
        setSizeFull();
    }
}
