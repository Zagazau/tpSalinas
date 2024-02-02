package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class clienteMenuController {

    @FXML
    private Button fazerEncomenda;

    @FXML
    private Button gerirEncomendas;

    @FXML
    private Button goBack;

    @FXML
    private Button pagarEncomenda;


    @FXML
    void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/login.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void fazerEncomenda(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/fazerEncomendaCliente.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Fazer Encomenda");
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void pagarEncomenda(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/pagarEncomenda.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("PagarEncomenda");
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    void gerirEncomendas(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gerirEncomendasCliente.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Fazer Encomenda");
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }





}
