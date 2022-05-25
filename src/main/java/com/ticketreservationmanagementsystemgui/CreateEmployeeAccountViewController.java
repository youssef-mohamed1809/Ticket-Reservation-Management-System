package com.ticketreservationmanagementsystemgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEmployeeAccountViewController implements Initializable {

    @FXML
    Parent current_root;

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    Button logout_btn;
    @FXML
    Button add_employee_btn;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    void createEmployee() throws IOException {
        String entered_username = username.getText();
        String entered_password = password.getText();

        boolean duplicatePresent = false;
        for(User u: Main.system_users){
            if(u.username.equals(entered_username)){
                duplicatePresent = true;
            }
        }

        if(!duplicatePresent){
            Main.system_users.add(new Employee(entered_username, entered_password));
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Employee Account Created");
            a.show();
            root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
            stage = (Stage)current_root.getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.setResizable(false);
            Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.show();

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Employee Account not Created because an account with this username is already present");
            a.show();
            root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
            stage = (Stage)current_root.getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.setResizable(false);
            Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.show();
        }
    }

    @FXML
    void logout() throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_employee_btn.setOnMouseEntered(e -> add_employee_btn.setTextFill(Paint.valueOf("#00FFAB")));
        add_employee_btn.setOnMouseExited(e -> add_employee_btn.setTextFill(Paint.valueOf("white")));

        logout_btn.setOnMouseEntered(e -> logout_btn.setTextFill(Paint.valueOf("#EB5353")));
        logout_btn.setOnMouseExited(e -> logout_btn.setTextFill(Paint.valueOf("white")));
    }
}
