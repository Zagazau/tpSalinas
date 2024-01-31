package com.example.trabpraticosalinas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.security.auth.login.LoginException;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;

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
    void login(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            String user = usernameField.getText();
            String password = passwordField.getText();
            SessionData sd = new SessionData();
            boolean found = false;

            Repositorio repo = Repositorio.getRepositorio();

            for (Admin a : repo.getAdminsMap().values()) {
                if (usernameField.getText().equalsIgnoreCase(a.getUsername()) && passwordField.getText().equals(a.getPassword())) {
                    sd.loggedAdmin = a;
                    found = true;
                    System.out.println("Login com Sucesso!");
                    Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Admin");
                    stage.show();
                }
            }

        } catch (IOException e) {
            System.out.println("Erro na funcao Login! \n" + e);
        }
    }

    @FXML
    public void register(ActionEvent event) {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/registar.fxml"));
            Scene regCena = new Scene(root);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
