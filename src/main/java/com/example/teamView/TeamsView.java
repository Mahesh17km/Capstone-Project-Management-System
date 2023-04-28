package com.example.teamView;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/teamsview")
public class TeamsView extends VerticalLayout {
    public TeamsView(TeamsService service){
        Grid<com.example.project.Capstone> grid = new Grid<>(com.example.project.Capstone.class);
        grid.setItems(service.findAll());

//        grid.setColumnOrder(
//                // Columns keys are the exact property names of the bean class
//                grid.getColumnByKey("team_id"),
//                grid.getColumnByKey("guide"),
//                grid.getColumnByKey("students"),
//                grid.getColumnByKey("project_title")
//        );

        add(grid);
        setSizeFull();
    }
}
