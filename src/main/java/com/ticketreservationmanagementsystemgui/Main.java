package com.ticketreservationmanagementsystemgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    static ArrayList<Category> categories = new ArrayList();
    public static ArrayList<User> system_users = new ArrayList<User>();
    public static ArrayList<Client> clients = new ArrayList<Client>();
    @Override
    public void start(Stage stage) throws IOException {
        system_users.add(new Admin("amgad_12", "1234"));
        system_users.add(new Employee("ayman_12", "1234"));
        clients.add(new Client("youssef", "3432", "Male", "2793864", "1234"));
        clients.add(new Client("mohamed", "3432", "Male", "2793864", "12345"));
        Category category1 = new Category("Theater");
        category1.events.add(new Event("Hamlet", "London", "30/5/2022", "22:00", "00:00", 200, ""));
        categories.add(category1);
        clients.get(0).addEvent(category1.events.get(0));
        Category category2 = new Category("Football Matches");
        category2.events.add(new Event("Barcelona vs Real Madrid", "Camp Nou", "30/10/2022", "22:00", "00:00", 2000, ""));
        categories.add(category2);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        Image icon = new Image(Main.class.getResource("Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}