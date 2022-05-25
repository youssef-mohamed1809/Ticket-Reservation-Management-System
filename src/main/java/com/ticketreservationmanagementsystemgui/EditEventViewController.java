package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditEventViewController implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    Button saveButton;
    @FXML
    Parent current_root;
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
    void save() throws IOException {
        String name = event_name.getText();
        String location = event_location.getText();
        int tickets = Integer.parseInt(event_tickets.getText());
        String date = event_date.getValue().toString();
        String start = event_start_time.getText();
        String end = event_end_time.getText();

        boolean found;
        found = true;
        for(Category c: Main.categories){
            for(Event e: c.events){
                if(e.name.equals(EventViewController.event_edited)){
                    found = true;
                    e.name = name;
                    e.place = location;
                    e.tickets = tickets;
                    e.date = date;
                    e.start_time = start;
                    e.end_time = end;
                }
            }
            if(found){
                break;
            }
        }

        root = FXMLLoader.load(getClass().getResource("event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Events");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void add_category(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-category-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Category");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void showCategories(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("category-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Categories");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void addEvent() throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Event");
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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

        saveButton.setOnMouseEntered(e -> logout_btn.setTextFill(Paint.valueOf("#00FFAB")));
        saveButton.setOnMouseExited(e -> logout_btn.setTextFill(Paint.valueOf("white")));
        boolean found = false;
        for(Category c: Main.categories){
            for(Event e: c.events){
                if(e.name.equals(EventViewController.event_edited)){
                    found = true;
                    event_name.setText(EventViewController.event_edited);
                    break;
                }
            }
            if(found){
                break;
            }
        }


    }
}
