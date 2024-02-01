package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class criarLoteController {

    @FXML
    private ChoiceBox<?> UserTypeChoiceBox;

    @FXML
    private Button backButton;

    @FXML
    private Button criarLote;

    @FXML
    private TextField diaField;

    @FXML
    private TextField pesoField;

    @FXML
    void criarLote(ActionEvent event) {

    }

    @FXML
    void goback(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpratico/gestorProdMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu Gestor Produção");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
