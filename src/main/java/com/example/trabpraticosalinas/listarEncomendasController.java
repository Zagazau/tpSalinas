
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

public class listarEncomendasController {

    @FXML
    private TableColumn<?, ?> DateColumn;

    @FXML
    private TableColumn<?, ?> Cliente;

    @FXML
    private TableColumn<?, ?> ValorCollum;

    @FXML
    private TableView<?> encomendasTable;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> encomendaCollum;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

  /*   @FXML
   public void initialize() {
        Repositorio repositorio = Repositorio.getRepo();
        repositorio.deserialize("info.repo");

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        NIFColumn.setCellValueFactory(new PropertyValueFactory<>("NIF"));
        CCNumberColumn.setCellValueFactory(new PropertyValueFactory<>("numCC"));
        morada.setCellValueFactory(new PropertyValueFactory<>("morada"));
        localidade.setCellValueFactory(new PropertyValueFactory<>("localidade"));

        List<Cliente> clientes = new ArrayList<>();

        for (Cliente aux : repositorio.getClientesMap().values()) {
            clientes.add(aux);
        }

        ObservableList<Cliente> clientesList = FXCollections.observableArrayList(clientes);
        customersTable.setItems(clientesList);
    }

    */

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

}


