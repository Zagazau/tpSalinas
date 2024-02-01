package com.example.trabpraticosalinas;

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
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.List;

public class gerirClientesAdminController {

    @FXML
    private TableColumn<?, ?> CCNumberColumn;

    @FXML
    private TableColumn<?, ?> NIFColumn;

    @FXML
    private TableColumn<?, ?> NIFColumn1;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> customersTable;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> emailColumn2;

    @FXML
    private TableColumn<?, ?> fullnameColumn;

    @FXML
    private TableColumn<?, ?> phonenumberColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @FXML
    public void deleteCustomer(javafx.event.ActionEvent ActionEvent) {
        Cliente c = (Cliente) customersTable.getSelectionModel().getSelectedItem();

        if(c != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem a certeza que pretende eliminar este cliente?");
            alert.showAndWait();

            if(alert.getResult().getText().equals("OK")) {
                Repositorio repositorio = Repositorio.getRepositorio();

                repositorio.getClientesMap().remove(c.getNIF());


             /*   for (List<Appointment> appointments : repository.getAppointments().values()) {
                    Iterator<Appointment> iterator = appointments.iterator();
                    while (iterator.hasNext()) {
                        Appointment appointment = iterator.next();
                        if (appointment.getCustomer().getNIF().equals(customer.getNIF())) {
                            iterator.remove();
                        }
                    }
                }
*/
                repositorio.serialize("info.repo");
                customersTable.getItems().remove(c);
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Por favor, selecione um cliente!");
            alert.show();
        }
    }

    @FXML
    void goback(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpratico/adminMenu.fxml"));
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
