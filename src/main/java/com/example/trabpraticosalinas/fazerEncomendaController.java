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
            LocalDate dataEncomenda = datePicker.getValue();
            int quantidade = Integer.parseInt(quantidadeField.getText());

            Cliente cliente = SessionData.getLoggedCliente();
            List<produtoFinal> lotesProdutoFinal = new ArrayList<>();

            // Crie a encomenda sem chamar o método estático criarEncomenda
            Encomenda encomenda = new Encomenda(
                    0, // Use 0 como placeholder para o ID, pois o ID será atribuído pela lógica apropriada
                    dataEncomenda,
                    cliente,
                    lotesProdutoFinal,
                    EncomendaEstado.PROCESSADA
            );

            // Use o método estático criarEncomenda da EncomendaBll para atribuir um ID adequado
            EncomendaBll.criarEncomenda(encomenda, cliente);

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