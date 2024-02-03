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

import java.time.LocalDate;
import java.util.List;

public class gerirEncomendasController {

    @FXML
    private TableColumn<Encomenda, Integer> idencomenda;

    @FXML
    private TableColumn<Encomenda, LocalDate> DataCollum;

    @FXML
    private TableColumn<Encomenda, EncomendaEstado> estadoEncomendaCollum;

    @FXML
    private TableColumn<Encomenda, Double> ValorCollum;

    @FXML
    private TableView<Encomenda> encomendasTable;

    @FXML
    private Button backButton;

    @FXML
    private Button cancelarEncomendaButton;

    public gerirEncomendasController() {
    }
    @FXML
    void initialize() {
        // Configuração inicial da tabela
        idencomenda.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DataCollum.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ValorCollum.setCellValueFactory(new PropertyValueFactory<>("totalValue"));

        // Carrega as encomendas ao inicializar
        mostrarEncomendas();
    }

    private void mostrarEncomendas() {

        Cliente cliente = SessionData.getLoggedCliente();
        List<Encomenda> encomendas = cliente.getEncomendas();

        ObservableList<Encomenda> encomendasObservable = FXCollections.observableArrayList(encomendas);

        encomendasTable.setItems(encomendasObservable);
    }

    @FXML
    void cancelarEncomenda() {
        Encomenda encomendaSelecionada = encomendasTable.getSelectionModel().getSelectedItem();

        if (encomendaSelecionada != null) {
            Cliente cliente = SessionData.getLoggedCliente();
            cliente.getEncomendas().remove(encomendaSelecionada);

            encomendasTable.getItems().remove(encomendaSelecionada);
        }
    }

    @FXML
    public void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/clienteMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu Cliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
