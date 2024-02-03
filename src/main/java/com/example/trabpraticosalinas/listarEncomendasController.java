package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class listarEncomendasController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<Encomenda> encomendasTable;

    @FXML
    private TableColumn<Encomenda, Integer> encomendaCollum;

    @FXML
    private TableColumn<Encomenda, String> DateColumn;

    @FXML
    private TableColumn<Encomenda, EncomendaEstado> estadoEncomendaCollum;

    @FXML
    private TableColumn<Encomenda, Double> ValorCollum;

    @FXML
    private TableColumn<Cliente, String> Cliente;

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

    @FXML
    void initialize() {

        encomendaCollum.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ValorCollum.setCellValueFactory(new PropertyValueFactory<>("totalValue"));
        Cliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));

        mostrarEncomendas();
    }

    private void mostrarEncomendas() {
        List<Encomenda> todasEncomendas = EncomendaBll.obterTodasEncomendas();

        ObservableList<Encomenda> encomendasObservable = FXCollections.observableArrayList(todasEncomendas);

        encomendasTable.setItems(encomendasObservable);
    }


}
