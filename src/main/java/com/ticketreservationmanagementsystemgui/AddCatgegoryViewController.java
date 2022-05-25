package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCatgegoryViewController implements Initializable{
    @FXML
    Parent current_root;
    @FXML
    TextField category_name;
    @FXML
    Button add_cat_btn;


    Parent root;
    Stage stage;
    Scene scene;

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
    void add_cat(){
        boolean isEmpty = false;
        String category = category_name.getText();
        if (category.equals("")){
            isEmpty = true;
        }
        if(!isEmpty){
            boolean found = false;
            for(Category cat: Main.categories){
                if(cat.name.equals(category)){
                    found = true;
                }
            }

            if(found){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Category with this name is already available");
                a.show();
                category_name.setText("");
            }else{
                Main.categories.add(new Category(category));
                Alert a = new Alert((Alert.AlertType.CONFIRMATION));
                a.setContentText("Category successfully added");
                a.show();
                category_name.setText("");
            }

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Category name cannot be empty");
            a.show();
        }
    }

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
    void addEvent() throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Event");
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

        add_cat_btn.setOnMouseEntered(e -> add_cat_btn.setTextFill(Paint.valueOf("#00FFAB")));
        add_cat_btn.setOnMouseExited(e -> add_cat_btn.setTextFill(Paint.valueOf("white")));
    }
}
