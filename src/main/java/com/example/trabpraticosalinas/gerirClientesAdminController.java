package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gerirClientesAdminController {

    @FXML
    private TableColumn<Cliente, String> CCNumberColumn;

    @FXML
    private TableColumn<Cliente, String> NIFColumn;

    @FXML
    private TableColumn<Cliente, String> morada;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Cliente> customersTable;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private TableColumn<Cliente, String> localidade;

    @FXML
    private TableColumn<Cliente, String> fullnameColumn;

    @FXML
    private TableColumn<Cliente, String> phonenumberColumn;

    @FXML
    private TableColumn<Cliente, String> usernameColumn;


    @FXML
    public void initialize() {
        Repositorio repositorio = Repositorio.getRepo();
        repositorio.deserialize("info.repo");

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        NIFColumn.setCellValueFactory(new PropertyValueFactory<>("NIF"));
        CCNumberColumn.setCellValueFactory(new PropertyValueFactory<>("numCC"));
        morada.setCellValueFactory(new PropertyValueFactory<>("morada"));
        localidade.setCellValueFactory(new PropertyValueFactory<>("localidade"));

        List<Cliente> clientes = new ArrayList<>();

        for (Cliente aux : repositorio.getClientesMap().values()) {
            clientes.add(aux);
        }

        ObservableList<Cliente> clientesList = FXCollections.observableArrayList(clientes);
        customersTable.setItems(clientesList);
    }



    @FXML
    public void deleteCustomer(javafx.event.ActionEvent ActionEvent) {
        Cliente c = (Cliente) customersTable.getSelectionModel().getSelectedItem();

        if (c != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem a certeza que pretende eliminar este cliente?");
            alert.showAndWait();

            if (alert.getResult().getText().equals("OK")) {
                Repositorio repositorio = Repositorio.getRepositorio();

                repositorio.getClientesMap().remove(c.getNIF());

                repositorio.getClienteEncomendaMap().remove(c);

                repositorio.serialize("info.repo");
                customersTable.getItems().remove(c);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Por favor, selecione um cliente!");
            alert.show();
        }
    }



    @FXML
    void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/adminMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu Admin");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
