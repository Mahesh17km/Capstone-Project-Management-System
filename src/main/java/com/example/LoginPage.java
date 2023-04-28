package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import org.bson.Document;

@Route("")
public class LoginPage extends VerticalLayout {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private RadioButtonGroup<String> loginOption;

    public LoginPage() {
        // Center the login page
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        // Add heading with big font size
        H1 heading = new H1("Capstone Project Management System");
        heading.getStyle().set("font-size", "3em");
        add(heading);

        // Initialize components
        usernameField = new TextField("Username");
        passwordField = new PasswordField("Password");
        loginButton = new Button("Login");

        // Initialize radio button group for login options
        loginOption = new RadioButtonGroup<>();
        loginOption.setLabel("Select login option:");
        loginOption.setItems("Coordinator", "Guide/Mentor", "Student");

        // Add components to layout
        add(usernameField, passwordField, loginOption, loginButton);

        // Add click listener to login button
        loginButton.addClickListener(e -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();
            String selectedOption = loginOption.getValue();

            // Perform login action based on selected option
            if (isValidLogin(username, password,selectedOption)) {
                if (selectedOption.equals("Coordinator")) {
                    UI.getCurrent().navigate("index");
                } else if (selectedOption.equals("Guide/Mentor")) {
                    UI.getCurrent().navigate("index2");
                } else if (selectedOption.equals("Student")) {
                    UI.getCurrent().navigate("studentview");
                } else {
                    Notification.show("Please select a login option.");
                }
            }
            else{
                Notification.show("Invalid login credentials.");
            }
        });
    }

    private boolean isValidLogin(String username, String password, String selectedOption) {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("coordinators");
        MongoCollection<Document> collection = null;

        // Select the collection based on the selected login option
        if (selectedOption.equals("Coordinator")) {
            collection = database.getCollection("coordinators");
        } else if (selectedOption.equals("Guide/Mentor")) {
            collection = database.getCollection("guide");
        } else if (selectedOption.equals("Student")) {
            collection = database.getCollection("student");
        }

        if (collection != null) {
            // Search for matching user document in the selected collection
            Document userDoc = collection.find(new Document("username", username)).first();

            if (userDoc != null && userDoc.getString("password").equals(password)) {
                return true;
            }
        }

        return false;
    }
}


//package com.example;
//
//import com.example.faculty.FacultyView;
//import com.example.project.CapstoneView;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.html.Anchor;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.router.RouterLink;
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//import com.vaadin.flow.component.UI;
//
//@Route("/loginpage")
//public class LoginPage extends VerticalLayout {
//
//    private TextField usernameField;
//    private PasswordField passwordField;
//    private Button loginButton;
//    private RadioButtonGroup<String> loginOption;
//    private VerticalLayout loginOptionLayout;
//
//    public LoginPage() {
//        // Center the login page
//        setJustifyContentMode(JustifyContentMode.CENTER);
//        setAlignItems(Alignment.CENTER);
//
//        // Initialize components
//        usernameField = new TextField("Username");
//        passwordField = new PasswordField("Password");
//        loginButton = new Button("Login");
//
//        // Initialize radio button group for login options
//        loginOption = new RadioButtonGroup<>();
//        loginOption.setLabel("Select login option:");
//        loginOption.setItems("Coordinator", "Guide/Mentor", "Student");
//
//        // Add components to layout
//        add(usernameField, passwordField, loginOptionLayout(), loginButton);
//
//        // Add click listener to login button
//        loginButton.addClickListener(e -> {
//            String username = usernameField.getValue();
//            String password = passwordField.getValue();
//            String selectedOption = loginOption.getValue();
//
//            // Perform login action based on selected option
//            if (isValidLogin(username, password,selectedOption)) {
//                if (selectedOption.equals("Coordinator")) {
//                    UI.getCurrent().navigate("index");
//                } else if (selectedOption.equals("Guide/Mentor")) {
//                    UI.getCurrent().navigate("teamsview");
//                } else if (selectedOption.equals("Student")) {
//                    UI.getCurrent().navigate("studentview");
//                } else {
//                    Notification.show("Please select a login option.");
//                }
//            }
//            else{
//                Notification.show("Invalid login credentials.");
//            }
//        });
//    }
//
//    // Create layout for radio button group
//    private VerticalLayout loginOptionLayout() {
//        loginOptionLayout = new VerticalLayout();
//        loginOptionLayout.add(loginOption);
//        return loginOptionLayout;
//    }
//
//    private boolean isValidLogin(String username, String password, String selectedOption) {
//        // Connect to MongoDB
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = mongoClient.getDatabase("coordinators");
//        MongoCollection<Document> collection = null;
//
//        // Select the collection based on the selected login option
//        if (selectedOption.equals("Coordinator")) {
//            collection = database.getCollection("coordinators");
//        } else if (selectedOption.equals("Guide/Mentor")) {
//            collection = database.getCollection("guide");
//        } else if (selectedOption.equals("Student")) {
//            collection = database.getCollection("student");
//        }
//
//        if (collection != null) {
//            // Search for matching user document in the selected collection
//            Document userDoc = collection.find(new Document("username", username)).first();
//
//            if (userDoc != null && userDoc.getString("password").equals(password)) {
//                return true;
//            }
//        }
//
//        return false;
//    }


//    private boolean isValidLogin(String username, String password) {
//        // Connect to MongoDB
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = mongoClient.getDatabase("coordinators");
//        MongoCollection<Document> usersCollection1 = database.getCollection("coordinators");
//        MongoCollection<Document> usersCollection2 = database.getCollection("guide");
//
//        // Search for matching user document
//        Document userDoc1 = usersCollection1.find(new Document("username", username)).first();
//
//        // Check if user document exists and password is correct
//        if (userDoc1 != null && userDoc1.getString("password").equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//
//        Document userDoc2 = usersCollection2.find(new Document("username", username)).first();
//
//        // Check if user document exists and password is correct
//        if (userDoc2 != null && userDoc2.getString("password").equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}

//package com.example;
//
//import com.example.faculty.FacultyView;
//import com.example.project.CapstoneView;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.html.Anchor;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.router.RouterLink;
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//
//
////import javax.swing.text.Document;
//
//
//@Route("/loginpage")
//public class LoginPage extends VerticalLayout {
//
//    private TextField usernameField;
//    private PasswordField passwordField;
//    private Button loginButton;
//    private RouterLink coordinator;
//    private RouterLink mentor;
//    private Anchor student;
//
//    public LoginPage() {
//        // Initialize components
//        usernameField = new TextField("Username");
//        passwordField = new PasswordField("Password");
//        loginButton = new Button("Login");
//        coordinator = new RouterLink("Co-ordinator", CapstoneView.class);
//        mentor = new RouterLink("Guide/Mentor", FacultyView.class);
//        student = new Anchor("http://localhost:8080/studentview", "Student");
//
//        // Add click listener to login button
//        loginButton.addClickListener(e -> {
//            String username = usernameField.getValue();
//            String password = passwordField.getValue();
//
//            // Perform login action based on selected preference button
//            if (isValidLogin(username, password)) {
//                if (coordinator.getHref().equals(e.getSource())) {
//                    // Login action for option 1
//                } else if (mentor.getHref().equals(e.getSource())) {
//                    // Login action for option 2
//                } else if (student.getElement().equals(e.getSource())) {
//                    // Login action for option 3
//                } else {
//                    Notification.show("Please select a login preference.");
//                }
//            }
//            else{
//                Notification.show("Invalid login credentials.");
//                }
//        });
//
//        // Add components to layout
//        add(usernameField, passwordField, coordinator, mentor, student, loginButton);
//    }
//
//    private boolean isValidLogin(String username, String password) {
//        // Connect to MongoDB
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = mongoClient.getDatabase("coordinators");
//        MongoCollection<Document> usersCollection = database.getCollection("coordinators");
//
//        // Search for matching user document
//        Document userDoc = usersCollection.find(new Document("username", username)).first();
//
//        // Check if user document exists and password is correct
//        if (userDoc != null && userDoc.getString("password").equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//}
