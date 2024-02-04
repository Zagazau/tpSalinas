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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class criarLoteController {

    @FXML
    ObservableList<String> UserTypeList = FXCollections.observableArrayList("Sal", "Flor de Sal");

    @FXML
    private ChoiceBox<String> tipo;

    @FXML
    void initialize() {
        tipo.setItems(UserTypeList);
    }

    @FXML
    private Button backButton;

    @FXML
    private Button criarLote;

    @FXML
    private TextField diaField;

    @FXML
    private TextField pesoField;

    @FXML
    private DatePicker datePicker;



    @FXML
    void criarLote(javafx.event.ActionEvent event) {
        try {
            Repositorio repositorio = Repositorio.getRepo();

            produtoFinal produtoFinal = new produtoFinal();
            produtoFinal.setIdProdutoFinal(UUID.randomUUID());
            LocalDate dataCricao = datePicker.getValue();


            produtoFinal.setDataCricao(Date.from(dataCricao.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            repositorio.getProdutosFinaisMap().put(produtoFinal.getIdProdutoFinal(), produtoFinal);

            Repositorio.serialize(repositorio, "info.repo");

            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorProdMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu gestor prod");
            stage.show();
            System.out.println("Lote criado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorProdMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu Gestor Produção");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
