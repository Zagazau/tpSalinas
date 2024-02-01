package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.IOException;

public class registarController {

    @FXML
    ObservableList<String> UserTypeList = FXCollections.observableArrayList("Cliente", "GestorVendas", "GestorProdução");

    @FXML
    private TextField CCfield;

    @FXML
    private TextField NIFField;

    @FXML
    private ChoiceBox<String> UserTypeChoiceBox;

    @FXML
    private TextField addressField;

    @FXML
    private Button backButton;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField localidadeField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton2;

    @FXML
    private TextField teleField;

    @FXML
    private TextField usernameField;

    @FXML
    public void goBack(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        UserTypeChoiceBox.setItems(UserTypeList);
    }

    @FXML
    public <ClienteMenuController> void redirectToLogin(ActionEvent event) {
        try {
            String userType = UserTypeChoiceBox.getValue();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene loginScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.setTitle("Login");

            // Se o tipo de usuário for "Cliente", redirecione para o clienteMenu.fxml
            if ("Cliente".equals(userType)) {
                FXMLLoader clienteMenuLoader = new FXMLLoader(getClass().getResource("clienteMenu.fxml"));
                Parent clienteMenuRoot = clienteMenuLoader.load();
                ClienteMenuController clienteMenuController = clienteMenuLoader.getController();

                // Passe a informação do usuário, se necessário (por exemplo, o nome do cliente)
                // clienteMenuController.setNomeDoCliente(nomeDoCliente);

                Scene clienteMenuScene = new Scene(clienteMenuRoot);
                stage.setScene(clienteMenuScene);
                stage.setTitle("Cliente Menu");
            }

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public boolean register2(ActionEvent event) {
        if (checkNome(event) && checkLocalidade(event) && checkMorada(event) && checkTele(event) && checkCC(event) && checkNIF(event) && checkUsername(event) && checkPassword(event) && checkTipoUtilizador(event)) {
            if (UserTypeChoiceBox.getValue().equals("Cliente")) {
                Utilizador u1 = new Cliente();
                u1.setLocalidade(localidadeField.getText());
                u1.setMorada(addressField.getText());
                u1.setNome(fullNameField.getText());
                u1.setNIF(NIFField.getText());
                u1.setNumCC(CCfield.getText());
                u1.setTelefone(teleField.getText());
                u1.setUsername(usernameField.getText());
                u1.setPassword(passwordField.getText());

                Repositorio repositorio = new Repositorio();
                ClienteBll c = new ClienteBll(repositorio);
                c.criarNovoCliente(u1.getNome(), u1.getUsername(), u1.getPassword(), u1.getNumCC(), u1.getNIF(), u1.getTelefone(), u1.getMorada(), u1.getLocalidade());

                redirectToLogin(event);
            } else if (UserTypeChoiceBox.getValue().equals("GestorVendas")) {
                Utilizador gv1 = new gestorVendas();
                gv1.setLocalidade(localidadeField.getText());
                gv1.setMorada(addressField.getText());
                gv1.setNome(fullNameField.getText());
                gv1.setNIF(NIFField.getText());
                gv1.setNumCC(CCfield.getText());
                gv1.setTelefone(teleField.getText());
                gv1.setUsername(usernameField.getText());
                gv1.setPassword(passwordField.getText());
                Repositorio repositorio = new Repositorio();

                gestorVendasBll gv = new gestorVendasBll(repositorio);
                gv.criarNovoGestorVendas(gv1.getNome(), gv1.getUsername(), gv1.getPassword(), gv1.getNumCC(), gv1.getNIF(), gv1.getTelefone(), gv1.getMorada(), gv1.getLocalidade());

            } else if (UserTypeChoiceBox.getValue().equals("GestorProdução")) {
                Utilizador gp1 = new gestorProducao();
                gp1.setLocalidade(localidadeField.getText());
                gp1.setMorada(addressField.getText());
                gp1.setNome(fullNameField.getText());
                gp1.setNIF(NIFField.getText());
                gp1.setNumCC(CCfield.getText());
                gp1.setTelefone(teleField.getText());
                gp1.setUsername(usernameField.getText());
                gp1.setPassword(passwordField.getText());
                Repositorio repositorio = new Repositorio();

                gestorProducaoBll gp = new gestorProducaoBll(repositorio);
                gp.criarNovoGestorProducao(gp1.getNome(), gp1.getUsername(), gp1.getPassword(), gp1.getNumCC(), gp1.getNIF(), gp1.getTelefone(), gp1.getMorada(), gp1.getLocalidade());
            }

            // Remove o bloco try-catch redundante que estava criando um novo FXMLLoader
            // e uma nova Scene para o login.
            if (!checkUsername(event)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Username errado!");
                alert.show();
                return false;
            } else if (!checkPassword(event)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Por favor, insira uma password!");
                alert.show();
                return false;
            } else if (!checkTipoUtilizador(event)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Por favor, insira um tipo de utilizador!");
                alert.show();
                return false;
            } else if (!checkNIF(event)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("NIF errado. Por favor, insira novamente!");
                alert.show();
                return false;
            } else if (!checkTele(event)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Número de telemovel errado. Por favor, insira novamente!");
                alert.show();
                return false;
            }
        }
        return true;
    }

    @FXML
    public boolean checkNome(ActionEvent actionEvent) {
        String enteredNome = fullNameField.getText().trim();

        if (enteredNome.isEmpty()) {
            fullNameField.setStyle("-fx-border-color: red");
            return false;
        } else {
            fullNameField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkLocalidade(ActionEvent actionEvent) {
        String enteredLocalidade = localidadeField.getText().trim();

        if (enteredLocalidade.isEmpty()) {
            localidadeField.setStyle("-fx-border-color: red");
            return false;
        } else {
            localidadeField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkMorada(ActionEvent actionEvent) {
        String enteredMorada = addressField.getText().trim();

        if (enteredMorada.isEmpty()) {
            addressField.setStyle("-fx-border-color: red");
            return false;
        } else {
            addressField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkTele(ActionEvent actionEvent) {
        String enteredTelefone = teleField.getText().trim();

        if (enteredTelefone.isEmpty()) {
            teleField.setStyle("-fx-border-color: red");
            return false;
        } else {
            teleField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkCC(ActionEvent actionEvent) {
        String enteredCC = CCfield.getText().trim();

        if (enteredCC.isEmpty()) {
            CCfield.setStyle("-fx-border-color: red");
            return false;
        } else {
            CCfield.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkNIF(ActionEvent actionEvent) {
        String enteredNIF = NIFField.getText().trim();

        if (enteredNIF.length() == 9) {
            NIFField.setStyle("-fx-border-color: green");
            return true;
        } else {
            NIFField.setStyle("-fx-border-color: red");
            return false;
        }
    }

    @FXML
    public boolean checkUsername(ActionEvent actionEvent) {
        String enteredUsername = usernameField.getText().trim();

        if (enteredUsername.isEmpty()) {
            usernameField.setStyle("-fx-border-color: red");
            return false;
        } else {
            usernameField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkPassword(ActionEvent actionEvent) {
        if (passwordField.getText().isEmpty()) {
            passwordField.setStyle("-fx-border-color: red");
            return false;
        } else {
            passwordField.setStyle("-fx-border-color: green");
            return true;
        }
    }

    @FXML
    public boolean checkTipoUtilizador(ActionEvent actionEvent) {
        if (UserTypeChoiceBox.getValue() == null || UserTypeChoiceBox.getValue().isEmpty()) {
            UserTypeChoiceBox.setStyle("-fx-border-color: red");
            return false;
        } else {
            UserTypeChoiceBox.setStyle("-fx-border-color: green");
            return true;
        }
    }
}
