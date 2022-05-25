package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryViewController implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    ScrollPane scroll_bar;
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
    void add_category(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-category-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add Category");
        stage.setScene(scene);
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


        //Scroll Pane Functionality
        int y = 0;
        AnchorPane g = new AnchorPane();
        g.setStyle("-fx-background-color: #FEB19F");

        for(Category c: Main.categories){
            AnchorPane a = new AnchorPane();
            a.setStyle("-fx-background-color: #FFF2F2");
            Label cat_name = new Label(c.name);
            cat_name.setLayoutX(25);
            cat_name.setLayoutY(15);
            Button editBtn = new Button("Edit");
            editBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    TextInputDialog td = new TextInputDialog("Input new category name");
                    td.showAndWait().ifPresent(string -> c.name = string);
                    try {
                        root = FXMLLoader.load(getClass().getResource("category-view.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage)current_root.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Categories");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                }
            });
            Button deleteBtn = new Button("Delete");

            deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Main.categories.remove(c);
                    try {
                        root = FXMLLoader.load(getClass().getResource("category-view.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage)current_root.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Categories");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            });

            editBtn.setLayoutX(500);
            deleteBtn.setLayoutX(600);
            editBtn.setLayoutY(15);
            deleteBtn.setLayoutY(15);
            a.getChildren().add(cat_name);
            a.getChildren().add(editBtn);
            a.getChildren().add(deleteBtn);
            a.setPrefWidth(714);
            a.setPrefHeight(55);
            a.setLayoutY(y);
            y += 65;
            g.getChildren().add(a);
        }

        scroll_bar.setContent(g);
    }
}