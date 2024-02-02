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
    private Button goBack;

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
    void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/login.fxml"));
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
    public void initialize() {
        UserTypeChoiceBox.setItems(UserTypeList);
    }

    @FXML
    private void redirectToLogin(ActionEvent event, String fxmlPath, String title) {
        try {
            String userType = UserTypeChoiceBox.getValue();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene loginScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.setTitle("Login");

            if ("Cliente".equals(userType) || "gestorVendas".equals(userType) || "gestorProducao".equals(userType)) {
                FXMLLoader menuLoader = new FXMLLoader(getClass().getResource(fxmlPath));
                Parent menuRoot = menuLoader.load();
                Scene menuScene = new Scene(menuRoot);
                stage.setScene(menuScene);
                stage.setTitle(title);
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
                ClienteBll.criarNovoCliente((Cliente) u1);
                redirectToLogin(event, "login.fxml", "Login");
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

                gestorVendasBll.registargestorVendas((gestorVendas) gv1);
                redirectToLogin(event, "login.fxml", "login");
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

                gestorProducaoBll.registarGestorProducao((gestorProducao) gp1);
                redirectToLogin(event, "login.fxml", "Login");
            }

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

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.show();
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
