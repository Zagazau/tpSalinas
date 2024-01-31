package com.example.trabpraticosalinas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(root, 655, 500);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Repositorio repo;
        Repositorio.deserialize("info.repo");
        repo = Repositorio.getRepositorio();

        if (repo.getAdminsMap().isEmpty()) {
            Admin a1 = new Admin(
                    "Administrador",
                    "tiago",
                    "paulo",
                    "123456789",
                    "123456789",
                    "123456789",
                    "Rua1",
                    "ptl"
            );

            AdminBll.registarAdmin(a1);
        }
        launch();
    }
}