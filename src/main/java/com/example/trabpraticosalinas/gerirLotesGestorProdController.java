package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.util.ArrayList;
import java.util.List;

public class gerirLotesGestorProdController {

    @FXML
    private Button apagarLote;

    @FXML
    private Button backButton;

    @FXML
    private TableView<produtoFinal> lotesTable;

    @FXML
    private TableColumn<?, ?> dataLote;

    @FXML
    private TableColumn<?, ?> idLote;


    @FXML
    public void initialize() {
        idLote.setCellValueFactory(new PropertyValueFactory<>("idProdutoFinal"));
        dataLote.setCellValueFactory(new PropertyValueFactory<>("dataCricao"));

        mostrarLotes();
    }

    @FXML
    private void mostrarLotes() {
        try {
            Repositorio repositorio = Repositorio.getRepo();
            List<produtoFinal> lotes = new ArrayList<>(repositorio.getProdutosFinaisMap().values());

            ObservableList<produtoFinal> observableListLotes = FXCollections.observableArrayList(lotes);
            lotesTable.setItems(observableListLotes);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void apagarLote(ActionEvent actionEvent) {

        produtoFinal loteSelecionado = lotesTable.getSelectionModel().getSelectedItem();

        if (loteSelecionado != null) {
            try {
                Repositorio repositorio = Repositorio.getRepo();


                repositorio.getProdutosFinaisMap().remove(loteSelecionado.getIdProdutoFinal());


                Repositorio.serialize(repositorio, "info.repo");


                mostrarLotes();

                System.out.println("Lote removido com sucesso!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Selecione um lote para apagar.");
        }
    }
}

