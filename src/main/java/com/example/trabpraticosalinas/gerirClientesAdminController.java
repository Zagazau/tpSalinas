package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class gerirClientesAdminController {

    @FXML
    private TableColumn<?, ?> CCNumberColumn;

    @FXML
    private TableColumn<?, ?> NIFColumn;

    @FXML
    private TableColumn<?, ?> NIFColumn1;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> customersTable;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> emailColumn2;

    @FXML
    private TableColumn<?, ?> fullnameColumn;

    @FXML
    private TableColumn<?, ?> phonenumberColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @FXML
    void deleteCustomer(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

}
