package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddEventViewController implements Initializable {
    @FXML
    Parent current_root;


    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    Button add_ev_btn;
    @FXML
    Button logout_btn;
    @FXML
    Button add_category_btn;
    @FXML
    Button category_btn;
    @FXML
    Button event_btn;
    @FXML
    Button add_event_btn;

    @FXML
    TextField event_name;
    @FXML
    TextField event_location;
    @FXML
    TextField event_tickets;
    @FXML
    DatePicker event_date;
    @FXML
    TextField event_start_time;
    @FXML
    TextField event_end_time;
    @FXML
    TextField event_category;

    @FXML
    void showCategories(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("category-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Categories");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void add_category() throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-category-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Category");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void showEvents() throws IOException {
        root = FXMLLoader.load(getClass().getResource("event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Events");
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
    void add_ev() throws IOException {
        String name = event_name.getText();
        String category = event_category.getText();
        boolean category_found = false;
        boolean event_duplicate = false;
        for(Category c: Main.categories){
            if(c.name.equals(category)){
                category_found = true;
                for(Event e: c.events){
                    if(e.name.equals(name)){
                        event_duplicate = true;
                    }
                }
                break;
            }
        }

        if(category_found && !event_duplicate){
            Event e = new Event(name, event_location.getText(), event_date.getValue().toString(), event_start_time.getText(), event_end_time.getText(), Integer.parseInt(event_tickets.getText()));
            for(Category c: Main.categories){
                if(c.name.equals(category)){
                    c.events.add(e);
                }
            }
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Event successfully added");
            a.show();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("An error occured, please recheck the entered data");
            a.show();
        }
        root = FXMLLoader.load(getClass().getResource("add-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Event");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_category_btn.setOnMouseEntered(e -> add_category_btn.setTextFill(Paint.valueOf("#82DBD8")));
        add_category_btn.setOnMouseExited(e -> add_category_btn.setTextFill(Paint.valueOf("white")));

        add_event_btn.setOnMouseEntered(e -> add_event_btn.setTextFill(Paint.valueOf("#82DBD8")));
        add_event_btn.setOnMouseExited(e -> add_event_btn.setTextFill(Paint.valueOf("white")));

        event_btn.setOnMouseEntered(e -> event_btn.setTextFill(Paint.valueOf("#82DBD8")));
        event_btn.setOnMouseExited(e -> event_btn.setTextFill(Paint.valueOf("white")));

        category_btn.setOnMouseEntered(e -> category_btn.setTextFill(Paint.valueOf("#82DBD8")));
        category_btn.setOnMouseExited(e -> category_btn.setTextFill(Paint.valueOf("white")));

        logout_btn.setOnMouseEntered(e -> logout_btn.setTextFill(Paint.valueOf("#EB5353")));
        logout_btn.setOnMouseExited(e -> logout_btn.setTextFill(Paint.valueOf("white")));

        add_ev_btn.setOnMouseEntered(e -> add_ev_btn.setTextFill(Paint.valueOf("#00FFAB")));
        add_ev_btn.setOnMouseExited(e -> add_ev_btn.setTextFill(Paint.valueOf("white")));
    }
}
