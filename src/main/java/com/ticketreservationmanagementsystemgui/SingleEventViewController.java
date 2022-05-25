package com.ticketreservationmanagementsystemgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SingleEventViewController implements Initializable {

    @FXML
    Parent current_root;
    Parent root;
    Stage stage;
    Scene scene;

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
    Button book_btn;
    @FXML
    Button unbook_btn;


    @FXML
    TextArea event_info;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_client_btn.setOnMouseEntered(e -> add_client_btn.setTextFill(Paint.valueOf("#82DBD8")));
        add_client_btn.setOnMouseExited(e -> add_client_btn.setTextFill(Paint.valueOf("white")));

        book_btn.setOnMouseEntered(e -> book_btn.setTextFill(Paint.valueOf("#82DBD8")));
        book_btn.setOnMouseExited(e -> book_btn.setTextFill(Paint.valueOf("white")));

        search_event_btn.setOnMouseEntered(e -> search_event_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_event_btn.setOnMouseExited(e -> search_event_btn.setTextFill(Paint.valueOf("white")));

        search_category_btn.setOnMouseEntered(e -> search_category_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_category_btn.setOnMouseExited(e -> search_category_btn.setTextFill(Paint.valueOf("white")));

        search_client_btn.setOnMouseEntered(e -> search_client_btn.setTextFill(Paint.valueOf("#82DBD8")));
        search_client_btn.setOnMouseExited(e -> search_client_btn.setTextFill(Paint.valueOf("white")));

        unbook_btn.setOnMouseEntered(e -> unbook_btn.setTextFill(Paint.valueOf("#EB5353")));
        unbook_btn.setOnMouseExited(e -> unbook_btn.setTextFill(Paint.valueOf("white")));

        logout_btn.setOnMouseEntered(e -> logout_btn.setTextFill(Paint.valueOf("#EB5353")));
        logout_btn.setOnMouseExited(e -> logout_btn.setTextFill(Paint.valueOf("white")));
        for(Category c: Main.categories){
            for(Event e: c.events){
                if(e.name.equals(EmployeePanelViewController.searchedEvent)){
                    event_info.setText(e.toString());
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
    void searchClient(){
        TextInputDialog td = new TextInputDialog();
        td.setTitle("Client Information");
        td.setHeaderText("Enter Client Name or Serial Number");
        td.showAndWait().ifPresent(string -> {
            try {
                search(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    void search(String s) throws IOException {
        for(Client c: Main.clients){
            if(c.name.equals(s) || c.serial_number.equals(s)){
                EmployeePanelViewController.searchedClient = c.serial_number;
                root = FXMLLoader.load(getClass().getResource("client-view.fxml"));
                stage = (Stage)current_root.getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Add Client");
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
                    EmployeePanelViewController.searchedEvent = e.name;
                    root = FXMLLoader.load(getClass().getResource("single-event-view.fxml"));
                    stage = (Stage)current_root.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Add Client");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            }
        }
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
                EmployeePanelViewController.searchedCategory = c.name;
                root = FXMLLoader.load(getClass().getResource("single-category-view.fxml"));
                stage = (Stage)current_root.getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Add Client");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        }
    }


    @FXML
    void book(){
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Input client name or serial number");
        td.setTitle("Book Event");
        td.showAndWait().ifPresent(string -> {
            try {
                bookEvent(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void bookEvent(String s) throws IOException {
        boolean clientFound = false;
        for(Client c: Main.clients){
            if(c.name.equals(s) || c.serial_number.equals(s)){
                clientFound = true;
            }
        }

        if(clientFound){
            for(Category c: Main.categories){
                for(Event e: c.events){
                    if(e.name.equals(EmployeePanelViewController.searchedEvent)){
                        if(e.tickets > 0){
                            e.tickets--;
                            for(Client client: Main.clients){
                                if(client.name.equals(s) || client.serial_number.equals(s)){
                                    client.addEvent(e);
                                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                    a.setHeaderText("Event successfully booked");
                                    a.show();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Client not found");
            a.show();
        }
        root = FXMLLoader.load(getClass().getResource("single-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    void unbook(){
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Input client name or serial number");
        td.setTitle("Remove Booking");
        td.showAndWait().ifPresent(string -> {
            try {
                unbookEvent(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void unbookEvent(String s) throws IOException {
        boolean clientFound = false;
        for(Client c: Main.clients){
            if(c.name.equals(s) || c.serial_number.equals(s)){
                clientFound = true;
            }
        }

        if(clientFound){
            for(Category c: Main.categories){
                for(Event e: c.events){
                    if(e.name.equals(EmployeePanelViewController.searchedEvent)){
                            for(Client client: Main.clients){
                                if(client.name.equals(s) || client.serial_number.equals(s)){
                                    if(client.events.contains(e)){
                                        e.tickets++;
                                        client.removeEvent(e);
                                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                        a.setHeaderText("Booking removed successfully");
                                        a.show();
                                        break;
                                    }
                                }
                            }
                        }
                }
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Client not found");
            a.show();
        }
        root = FXMLLoader.load(getClass().getResource("single-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
