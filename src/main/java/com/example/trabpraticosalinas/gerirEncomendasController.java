package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class gerirEncomendasController {

    @FXML
    private TableColumn<?, ?> DataCollum;

    @FXML
    private TableColumn<?, ?> ValorCollum;

    @FXML
    private TableView<?> encomendasTable;

    @FXML
    private Button backButton;

    @FXML
    private Button cancelarEncomendaButton;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

    @FXML
    private TableColumn<?, ?> idencomenda;

    @FXML
    void cancelarEncomenda(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

}

