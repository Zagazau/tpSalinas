package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class listarEncomendasController {

    @FXML
    private TableColumn<?, ?> AppointmentIdColumn;

    @FXML
    private TableColumn<?, ?> AppointmentStateColumn;

    @FXML
    private TableColumn<?, ?> DateColumn;

    @FXML
    private TableColumn<?, ?> TotalValueColumn;

    @FXML
    private TableView<?> appointmentsTable;

    @FXML
    private Button backButton;

    @FXML
    void goBack(ActionEvent event) {

    }

}

