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

public class gerirLotesGestorProdController {

    @FXML
    private Button apagarLote;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> customersTable;

    @FXML
    private TableColumn<?, ?> diaLote;

    @FXML
    private TableColumn<?, ?> pesoLote;

    @FXML
    private TableColumn<?, ?> tipoLote;

    @FXML
    void apagarLote(ActionEvent event) {

    }

    @FXML
    void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorProdMenu.fxml"));
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

