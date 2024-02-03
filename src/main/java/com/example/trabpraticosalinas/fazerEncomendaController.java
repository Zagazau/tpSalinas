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

        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

public class fazerEncomendaController {

    @FXML
    private ChoiceBox<String> UserTypeChoiceBox;
    @FXML
    void initialize() {
        // Adicione os itens à lista UserTypeList
        ObservableList<String> UserTypeList = FXCollections.observableArrayList("Sal", "Flor de Sal");

        // Configure a ChoiceBox com a lista de itens
        UserTypeChoiceBox.setItems(UserTypeList);
    }

    @FXML
    private Button backButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button encomendar;

    @FXML
    private TextField quantidadeField;

    @FXML
    void fazerEncomenda(ActionEvent event) {
        try {
            // Recupera os valores dos campos
            LocalDate dataEncomenda = datePicker.getValue();
            int quantidade = Integer.parseInt(quantidadeField.getText());
            String tipoEncomenda = UserTypeChoiceBox.getValue();


            // Obtém o cliente logado a partir da SessionData
            Cliente cliente = SessionData.getLoggedCliente();

            // Adicione um log para depuração
            System.out.println("Cliente logado: " + cliente.getNome());

            // Crie a lista de lotesProdutoFinal (pode ajustar conforme necessário)
            List<produtoFinal> lotesProdutoFinal = new ArrayList<>();

            // Crie a encomenda
            Encomenda encomenda = new Encomenda(
                    // Defina os valores apropriados para idEncomenda e estado
                    1,
                    dataEncomenda,
                    cliente,  // Use o cliente obtido da SessionData
                    lotesProdutoFinal,
                    EncomendaEstado.PROCESSADA  // ou o estado inicial desejado
            );

            // Chame o método para criar a encomenda
            EncomendaBll.criarEncomenda(encomenda, cliente);

            // Redirecione para a página de gerir encomendas (ou ajuste conforme necessário)
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/clienteMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Gerir Encomendas");
            stage.show();
            System.out.println("Encomenda bem sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpraticosalinas/clienteMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("MenuCliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}