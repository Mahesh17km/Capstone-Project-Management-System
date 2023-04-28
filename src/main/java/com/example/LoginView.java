//package com.example;
//
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.login.LoginForm;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.server.auth.AnonymousAllowed;
//import jakarta.annotation.security.PermitAll;
//
//@Route("login")
//@AnonymousAllowed
//@PermitAll
//public class LoginView extends VerticalLayout {
//
//    public LoginView() {
//        setSizeFull();
//        setAlignItems(Alignment.CENTER);
//        setJustifyContentMode(JustifyContentMode.CENTER);
//
//        var login = new LoginForm();
//        login.setAction("login");
//
//        add(
//                new H1("Capstone Project Management System"),
//                login
//        );
//    }
//}