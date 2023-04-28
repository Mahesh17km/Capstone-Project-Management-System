package com.example.teams;

import com.example.student.Student;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
@Route("/teams")
public class TeamView extends VerticalLayout {
    public TeamView(TeamService service){
        GridCrud<Team> crud = new GridCrud<>(Team.class, service);
        add(crud);
        Grid<Team> grid = crud.getGrid();
        grid.setColumnOrder(
                // Columns keys are the exact property names of the bean class
                grid.getColumnByKey("team_id"),
                grid.getColumnByKey("guide"),
                grid.getColumnByKey("students"),
                grid.getColumnByKey("project_title")
                //grid.getColumnByKey("photo")

        );
        setSizeFull();
    }
}
