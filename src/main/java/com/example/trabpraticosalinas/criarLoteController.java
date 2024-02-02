package com.example.trabpraticosalinas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class criarLoteController {

    @FXML
    private ChoiceBox<?> UserTypeChoiceBox;

    @FXML
    private Button backButton;

    @FXML
    private Button criarLote;

    @FXML
    private TextField diaField;

    @FXML
    private TextField pesoField;

    @FXML
    void criarLote(javafx.event.ActionEvent actionEvent) {
        try {
            // Supondo que você tenha uma referência ao seu repositório
            Repositorio repositorio = Repositorio.getRepo();

            // Criar uma nova instância de ProdutoFinal
            produtoFinal produtoFinal = new produtoFinal();
            produtoFinal.setIdProdutoFinal(UUID.randomUUID()); // Gerar um UUID aleatório
            produtoFinal.setDataCricao(new Date()); // Definir a data de criação

            // Supondo que você tenha uma lista de LotesFabrico
            List<loteFabrico> lotesFabrico = null; /* Popule a lista de LotesFabrico conforme necessário */;
            produtoFinal.setLotes(lotesFabrico);

            // Adicionar o produto final ao mapa no repositório
            repositorio.getProdutosFinaisMap().put(produtoFinal.getIdProdutoFinal(), produtoFinal);

            // Serializar o repositório atualizado
            Repositorio.serialize(repositorio, "info.repo");

            // Redirecionar para outra cena ou realizar outras ações
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/gestorProdMenu.fxml"));
                Scene regCena = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(regCena);
                stage.setTitle("Menu Gestor Produção");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goback(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpratico/gestorProdMenu.fxml"));
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
