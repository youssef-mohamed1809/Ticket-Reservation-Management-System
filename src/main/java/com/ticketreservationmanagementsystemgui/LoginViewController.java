package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginViewController{

    @FXML
    TextField username_field;
    @FXML
    PasswordField password_field;
    @FXML
    Parent current_root;

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    void login(ActionEvent event) throws IOException {
        String username = username_field.getText();
        String password = password_field.getText();


        boolean adminLoggedIn = false;
        boolean employeeLoggedIn = false;
        for(User user: Main.system_users){
            if(user.username.equals(username)){
                if(user.password.equals(password)){
                    if(user.job.equals("Admin")){
                        adminLoggedIn = true;
                        System.out.println("Welcome Admin");
                    }else{
                        employeeLoggedIn = true;
                        System.out.println("Welcome Employee");
                    }
                }
            }
        }

        if(!adminLoggedIn && !employeeLoggedIn){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Please recheck the entered credentials");
            a.show();
        }else if(adminLoggedIn){
            loadAdminScreen();
        }else if(employeeLoggedIn){
            loadEmployeeScreen();
        }
    }

    void loadAdminScreen() throws IOException {
        root = FXMLLoader.load(getClass().getResource("admin-panel-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Admin Panel");
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    void loadEmployeeScreen() throws IOException {
        root = FXMLLoader.load(getClass().getResource("employee-panel-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Employee Panel");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void createAccount() throws IOException {
        root = FXMLLoader.load(getClass().getResource("create-account-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Create Employee Account");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

}
