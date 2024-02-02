package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class criarUtilizadoresAdminController {

    @FXML
    private TextField CCfield;

    @FXML
    private TextField NIFfield;

    @FXML
    ObservableList<String> UserTypeList = FXCollections.observableArrayList("Cliente", "GestorVendas", "GestorProdução");

    @FXML
    private ChoiceBox<String> UserTypeChoiceBox;

    @FXML
    private TextField addressField;

    @FXML
    private Button createUser;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField localidadeField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField teleField;

    @FXML
    private TextField usernameField;

    @FXML
    public void initialize() {
        UserTypeChoiceBox.setItems(UserTypeList);
    }

    @FXML
    void goback(ActionEvent event) {
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

    @FXML
    public boolean createUser(ActionEvent event) {
        if (checkNome(event) && checkLocalidade(event) && checkMorada(event) && checkTele(event) && checkCC(event) && checkNIF(event) && checkUsername(event) && checkPassword(event) && checkTipoUtilizador(event)) {
            if (UserTypeChoiceBox.getValue().equals("Cliente")) {
                Utilizador u1 = new Cliente();
                u1.setLocalidade(localidadeField.getText());
                u1.setMorada(addressField.getText());
                u1.setNome(fullNameField.getText());
                u1.setNIF(NIFfield.getText());
                u1.setNumCC(CCfield.getText());
                u1.setTelefone(teleField.getText());
                u1.setUsername(usernameField.getText());
                u1.setPassword(passwordField.getText());

                ClienteBll.criarNovoCliente((Cliente) u1);

                Repositorio repositorio = new Repositorio();

            } else if (UserTypeChoiceBox.getValue().equals("GestorVendas")) {
                Utilizador gv1 = new gestorVendas();
                gv1.setLocalidade(localidadeField.getText());
                gv1.setMorada(addressField.getText());
                gv1.setNome(fullNameField.getText());
                gv1.setNIF(NIFfield.getText());
                gv1.setNumCC(CCfield.getText());
                gv1.setTelefone(teleField.getText());
                gv1.setUsername(usernameField.getText());
                gv1.setPassword(passwordField.getText());
                Repositorio repositorio = new Repositorio();

                gestorVendasBll.registargestorVendas((gestorVendas) gv1);

            } else if (UserTypeChoiceBox.getValue().equals("GestorProdução")) {
                Utilizador gp1 = new gestorProducao();
                gp1.setLocalidade(localidadeField.getText());
                gp1.setMorada(addressField.getText());
                gp1.setNome(fullNameField.getText());
                gp1.setNIF(NIFfield.getText());
                gp1.setNumCC(CCfield.getText());
                gp1.setTelefone(teleField.getText());
                gp1.setUsername(usernameField.getText());
                gp1.setPassword(passwordField.getText());
                Repositorio repositorio = new Repositorio();

                gestorProducaoBll.registarGestorProducao((gestorProducao) gp1);
            }

            try {
                Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                Scene regCena = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(regCena);
                stage.setTitle("Login");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
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
                alert.setHeaderText("Numero de telemovel errado. Por favor, insira novamente!");
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
        String enteredNIF = NIFfield.getText().trim();

        if (enteredNIF.length() == 9) {
            NIFfield.setStyle("-fx-border-color: green");
            return true;
        } else {
            NIFfield.setStyle("-fx-border-color: red");
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

