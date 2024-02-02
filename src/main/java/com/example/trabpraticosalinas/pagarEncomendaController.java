package com.example.trabpraticosalinas;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.stage.Stage;

public class pagarEncomendaController {

    @FXML
    private TableColumn<?, ?> DataColumn;

    @FXML
    private TableColumn<?, ?> TotalValueColumn;

    @FXML
    private TableView<?> encomendasTable;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> estadoEncomendaCollum;

    @FXML
    private TableColumn<?, ?> idEncomendaCollum;

    @FXML
    private Button payButton;

    @FXML
    void goback(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabpratico/clienteMenu.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Menu Cliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pagarEncomenda(ActionEvent event) {

    }

}