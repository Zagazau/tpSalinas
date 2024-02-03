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
    private Button backButton;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

    @FXML
    private TableColumn<?, ?> idEncomendaCollum;

    @FXML
    private Button payButton;


    @FXML
    public void initialize() {
        // Configuração inicial da tabela
        idEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TotalValueColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));

        // Carrega as encomendas quando a cena é carregada
        mostrarEncomendas();
    }

    private void mostrarEncomendas() {
        Repositorio repositorio = Repositorio.getRepositorio();
        repositorio.deserialize("info.repo");

        // Supondo que você tenha uma referência ao ClienteAtual ou Cliente logado
        // e que este objeto tenha um método getEncomendas
        List<Encomenda> encomendas = Cliente.getEncomendas();

        // Crie uma ObservableList a partir da lista de encomendas
        ObservableList<Encomenda> encomendasObservable = FXCollections.observableArrayList(encomendas);

        // Defina os itens da tabela com a ObservableList
        encomendasTable.setItems(encomendasObservable);

        // Agora, vincule as colunas aos campos corretos da classe Encomenda
        idEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<>("encomendaData"));
        estadoEncomendaCollum.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TotalValueColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));

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