package com.example.trabpraticosalinas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class registarController {

    @FXML
    ObservableList<String> UserTypeList = FXCollections.observableArrayList("Cliente", "GestorVendas", "GestorProdução");

    @FXML
    private TextField CCfield;

    @FXML
    private TextField NIFField;

    @FXML
    private ChoiceBox<?> UserTypeChoiceBox;

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
    void goBack(ActionEvent event) {

    }


    @FXML
    void register2(javafx.event.ActionEvent event) {
        if (checkNome(event) && checkLocalidade(event) && checkAddress(event) && && checktele(event) && checkCC(event) && checkNIF(event) &&  checkUsername(event) && checkPassword(event) && checkUserType(event)) {
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
                Utilizador gp1 = new gestorVendas();
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


                try {
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Login");
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (checkUsername(event) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Username errado!");
                alert.show();
                return;
            } else if (checkPassword(event) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Por favor, insira uma password!");
                alert.show();
                return;
            } else if (checkUserType(event) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Por favor, insira um tipo de utilizador!");
                alert.show();
                return;
            } else if (checkNIF(event) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("NIF errado. Por favor, insira novamente!");
                alert.show();
                return;
            } else if (checkPhoneNumber(event) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Numero de telemovel errado. Por favor, insira novamente!");
                alert.show();
                return;

            }

        }

        public boolean checkUserType (javafx.event.ActionEvent actionEvent){
            if (UserTypeChoiceBox.getValue().isEmpty()) {
                UserTypeChoiceBox.setStyle("-fx-border-color: red");
                return false;
            } else {
                UserTypeChoiceBox.setStyle("-fx-border-color: green");
                return true;
            }
        }

        @FXML
        public boolean checkUsername (javafx.event.ActionEvent actionEvent){
            Repositorio repo = Repositorio.getRepositorio();
            repo.deserialize("info.repo");

            String enteredUsername = usernameField.getText().trim();

            if (enteredUsername.isEmpty()) {
                usernameField.setStyle("-fx-border-color: red");
                return false;
            }

            for (Cliente c : repo.getClientesMap().values()) {
                if (enteredUsername.equals(c.getUsername())) {
                    usernameField.setStyle("-fx-border-color: red");
                    return false;
                }
            }

            for (CompanyOwner companyOwner : repo.getCompanyOwners().values()) {
                if (enteredUsername.equals(companyOwner.getUsername())) {
                    usernameField.setStyle("-fx-border-color: red");
                    return false;
                }
            }

            for (Admin admin : repo.getAdmins().values()) {
                if (enteredUsername.equals(admin.getUsername())) {
                    usernameField.setStyle("-fx-border-color: red");
                    return false;
                }
            }

            for (Employee employee : repo.getEmployees().values()) {
                if (enteredUsername.equals(employee.getUsername())) {
                    usernameField.setStyle("-fx-border-color: red");
                    return false;
                }
            }

            usernameField.setStyle("-fx-border-color: green");
            return true;
        }

        @FXML
        public boolean checkPassword (javafx.event.ActionEvent actionEvent){
            if (passwordField.getText().isEmpty()) {
                passwordField.setStyle("-fx-border-color: red");
                return false;

            } else {
                passwordField.setStyle("-fx-border-color: green");
                return true;
            }
        }

        @FXML
        public boolean checkNIF (javafx.event.ActionEvent actionEvent){
            if (NIFField.getText().length() == 9) {
                NIFField.setStyle("-fx-border-color: green");
                return true;
            } else {
                NIFField.setStyle("-fx-border-color: red");
                return false;
            }
        }

        public boolean checkPhoneNumber (javafx.event.ActionEvent actionEvent){
            if (phoneNumberField.getText().length() == 9) {
                phoneNumberField.setStyle("-fx-border-color: green");
                return true;
            } else {
                phoneNumberField.setStyle("-fx-border-color: red");
                return false;
            }
        }

    }

}

