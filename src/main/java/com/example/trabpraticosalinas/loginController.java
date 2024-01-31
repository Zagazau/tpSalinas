package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private Button loginButton;

    @FXML
    private Button newAccount;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;


    @FXML
    void register(javafx.event.ActionEvent ActionEvent) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("registar.fxml"));
            Scene regCena = new Scene
                    (root);
            Stage stage = (Stage) ((Node) ActionEvent.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void login(ActionEvent event) {

    }




}

