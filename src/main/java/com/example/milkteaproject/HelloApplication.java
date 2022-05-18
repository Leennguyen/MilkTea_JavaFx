package com.example.milkteaproject;

import com.example.milkteaproject.models.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var mg = new Manager();

        var txtId = new TextField();
        var btnCreate = new Button("create Product");
        btnCreate.setOnAction(event -> {
            String id = txtId.getText();
            var product = new Product(id, "rfdsgf", 3457634, "sgfjsdgf");
            if (mg.createProduct(product)) {//new alert;
            };
        });
        Scene scene = new Scene(new Group(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}