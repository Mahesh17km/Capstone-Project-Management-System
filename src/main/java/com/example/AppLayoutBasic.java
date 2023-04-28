package com.example;

import com.example.faculty.FacultyView;
import com.example.project.CapstoneView;
import com.example.student.StudentView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route("index")
@PermitAll
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        createHeader();
        createContent();
    }

    public void createHeader() {
        H1 logo = new H1("Capstone Projects Management System");
        logo.addClassNames("text-l", "m-m", "text-center");

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames("py-0", "py-m");

        addToNavbar(header);
    }

    public void createContent() {
        Image image = new Image("https://www.pessat.com/img/PESLogo.jpg", "Placeholder Image");
        image.setWidth("400px");

        Button projectsButton = new Button("Projects", event -> {
            UI.getCurrent().navigate(CapstoneView.class);
        });
        projectsButton.setHeight("200px");
        projectsButton.setWidth("200px");

        Button studentsButton = new Button("Students", event -> {
            UI.getCurrent().navigate(StudentView.class);
        });
        studentsButton.setHeight("200px");
        studentsButton.setWidth("200px");

        Button facultyButton = new Button("Faculty", event -> {
            UI.getCurrent().navigate(FacultyView.class);
        });
        facultyButton.setHeight("200px");
        facultyButton.setWidth("200px");

        HorizontalLayout buttonLayout = new HorizontalLayout(
                projectsButton,
                studentsButton,
                facultyButton
        );
        buttonLayout.setSpacing(true);

        VerticalLayout content = new VerticalLayout(
                image,
                buttonLayout
        );
        content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setSpacing(true);

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setPadding(true);
        wrapper.setSpacing(true);
        wrapper.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        wrapper.add(content);

        wrapper.setAlignSelf(FlexComponent.Alignment.CENTER, content);

        wrapper.setSizeFull();

        setContent(wrapper);
    }
}