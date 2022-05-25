package com.ticketreservationmanagementsystemgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeePanelViewController implements Initializable {
    public static String searchedClient;

    public static String searchedEvent;
    public static String searchedCategory;
    @FXML
    Parent current_root;

    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    Button logout_btn;
    @FXML
    Button add_client_btn;
    @FXML
    Button search_category_btn;
    @FXML
    Button search_event_btn;
    @FXML
    Button search_client_btn;


    @FXML
    void searchClient(){
        TextInputDialog td = new TextInputDialog();
        td.setTitle("Client Information");
        td.setHeaderText("Enter Client Name or Serial Number");
        td.showAndWait().ifPresent(string -> {
            try {
                searchC(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    void searchC(String s) throws IOException {
        for(Client c: Main.clients){
            if(c.name.equals(s) || c.serial_number.equals(s)){
                searchedClient = c.serial_number;
                root = FXMLLoader.load(getClass().getResource("client-view.fxml"));
                stage = (Stage)current_root.getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("View Client");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        }
    }

    @FXML
    void searchEvent(){
        TextInputDialog td = new TextInputDialog();
        td.setTitle("Event Name");
        td.setHeaderText("Enter Event Name");
        td.showAndWait().ifPresent(string -> {
            try {
                searchE(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void searchE(String s) throws IOException {
        for(Category c: Main.categories){
            for(Event e: c.events){
                if(e.name.equals(s)){
                    searchedEvent = e.name;
                    root = FXMLLoader.load(getClass().getResource("single-event-view.fxml"));
                    stage = (Stage)current_root.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("View Event");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            }
        }
    }

    @FXML
    void addClient() throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-client-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void logout() throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void searchCategory(){
        TextInputDialog td = new TextInputDialog();
        td.setTitle("Category Name");
        td.setHeaderText("Enter Category Name");
        td.showAndWait().ifPresent(string -> {
            try {
                searchCat(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void searchCat(String s) throws IOException {
        for(Category c: Main.categories){
                if(c.name.equals(s)){
                    searchedCategory = c.name;
                    root = FXMLLoader.load(getClass().getResource("single-category-view.fxml"));
                    stage = (Stage)current_root.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("View Category");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_client_btn.setOnMouseEntered(e -> add_client_btn.setTextFill(Paint.valueOf("#82DBD8")));
        add_client_btn.setOnMouseExited(e -> add_client_btn.setTextFill(Paint.valueOf("white")));

        search_event_btn.setOnMouseEntered(e -> search_event_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_event_btn.setOnMouseExited(e -> search_event_btn.setTextFill(Paint.valueOf("white")));

        search_category_btn.setOnMouseEntered(e -> search_category_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_category_btn.setOnMouseExited(e -> search_category_btn.setTextFill(Paint.valueOf("white")));

        search_client_btn.setOnMouseEntered(e -> search_client_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_client_btn.setOnMouseExited(e -> search_client_btn.setTextFill(Paint.valueOf("white")));

        logout_btn.setOnMouseEntered(e -> logout_btn.setTextFill(Paint.valueOf("#EB5353")));
        logout_btn.setOnMouseExited(e -> logout_btn.setTextFill(Paint.valueOf("white")));
    }
}
