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

        import java.util.List;

public class pagarEncomendaController {

    @FXML
    private TableColumn<?, ?> DataColumn;

    @FXML
    private TableColumn<?, ?> TotalValueColumn;

    @FXML
    private TableView<Encomenda> encomendasTable;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

    @FXML
    private TableColumn<?, ?> idEncomendaCollum;

    @FXML
    private TableColumn<?, ?> tipoProduto;

    @FXML
    private TableColumn<?, ?> quantidade;

    @FXML
    private Button payButton;

    @FXML
    private Button backButton;


    @FXML
    public void initialize() {
        idEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TotalValueColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));
        tipoProduto.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));


        mostrarEncomendas();
    }

    private void mostrarEncomendas() {
        Repositorio repositorio = Repositorio.getRepositorio();
        repositorio.deserialize("info.repo");
        Cliente cliente = SessionData.getLoggedCliente();

        List<Encomenda> encomendas = cliente.getEncomendas();

        ObservableList<Encomenda> encomendasObservable = FXCollections.observableArrayList(encomendas);

        encomendasTable.setItems(encomendasObservable);

        idEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TotalValueColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));
        tipoProduto.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

    }
    @FXML
    void pagarEncomenda(javafx.event.ActionEvent event) {

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