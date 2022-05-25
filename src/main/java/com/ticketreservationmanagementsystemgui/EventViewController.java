package com.ticketreservationmanagementsystemgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventViewController implements Initializable {

    public static String event_edited;


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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    void editEvent() throws IOException {
        root = FXMLLoader.load(getClass().getResource("edit-event-view.fxml"));
        stage = (Stage)current_root.getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Edit Event");
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
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
        if(this.scroll_bar != null){
            int y = 0;
            AnchorPane g = new AnchorPane();
            g.setStyle("-fx-background-color: #FEB19F");

            for(Category c: Main.categories){
                for(Event e: c.events){
                    AnchorPane a = new AnchorPane();
                    a.setStyle("-fx-background-color: #FFF2F2");
                    Label ev_name = new Label(e.name);
                    ev_name.setLayoutX(25);
                    ev_name.setLayoutY(15);
                    Button editBtn = new Button("Edit");
                    Button deleteBtn = new Button("Delete");

                    editBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                event_edited = e.name;
                                editEvent();

                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });

                    deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            c.events.remove(e);
                            try {
                                root = FXMLLoader.load(getClass().getResource("event-view.fxml"));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage = (Stage)current_root.getScene().getWindow();
                            scene = new Scene(root);
                            stage.setTitle("Events");
                            Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
                            stage.getIcons().add(icon);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        }
                    });

                    editBtn.setLayoutX(500);
                    deleteBtn.setLayoutX(600);
                    editBtn.setLayoutY(15);
                    deleteBtn.setLayoutY(15);
                    a.getChildren().add(ev_name);
                    a.getChildren().add(editBtn);
                    a.getChildren().add(deleteBtn);
                    a.setPrefWidth(714);
                    a.setPrefHeight(55);
                    a.setLayoutY(y);
                    y += 65;
                    g.getChildren().add(a);
                }
            }

            scroll_bar.setContent(g);
        }
    }
}
