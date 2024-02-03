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

            Repositorio repo = Repositorio.getRepositorio();

            for (Admin a : repo.getAdminsMap().values()) {
                if (usernameField.getText().equalsIgnoreCase(a.getUsername()) && passwordField.getText().equals(a.getPassword())) {
                    sd.loggedAdmin = a;
                    System.out.println("Login com Sucesso como Admin!");
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/adminMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Admin");
                    stage.show();
                    return;
                }
            }

            for (Cliente c : repo.getClientesMap().values()) {
                if (user.equalsIgnoreCase(c.getUsername()) && password.equals(c.getPassword())) {
                    sd.loggedCliente = c;
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/clienteMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Cliente");
                    stage.show();

                    return;
                }
            }

            for (gestorProducao gp : repo.getGestoresProducaoMap().values()) {
                if (user.equalsIgnoreCase(gp.getUsername()) && password.equals(gp.getPassword())) {
                    sd.loggedgestorProducao = gp;
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorProdMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Gestor de Produção");
                    stage.show();
                    return;
                }
            }

            for (gestorVendas gv : repo.getGestoresVendasMap().values()) {
                if (user.equalsIgnoreCase(gv.getUsername()) && password.equals(gv.getPassword())) {
                    sd.loggedgestorVendas = gv;
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorVendasMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Gestor de Vendas");
                    stage.show();
                    return;
                }
            }

            System.out.println("Login falhou. Credenciais inválidas.");

        } catch (IOException e) {
            System.out.println("Erro na função Login! \n" + e);
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
