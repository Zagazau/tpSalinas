package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class fazerEncomendaController {

    @FXML
    private Button backButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button encomendar;

    @FXML
    private TextField quantidadeField;

    @FXML
    void fazerEncomenda(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/clienteMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("MenuCliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
