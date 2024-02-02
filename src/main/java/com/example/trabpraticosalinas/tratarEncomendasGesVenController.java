package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class tratarEncomendasGesVenController {

    @FXML
    private TableColumn<?, ?> DateColumn;

    @FXML
    private TableColumn<?, ?> ValorCollum;

    @FXML
    private Button alterarEncomenda;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> encomendaCollum;

    @FXML
    private TableView<?> encomendasTable;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

    @FXML
    void alterarEncomenda(ActionEvent event) {

    }

    @FXML
    void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorVendasMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
